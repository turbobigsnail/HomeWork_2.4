package org.example;

import org.example.exception.WrongLoginException;
import org.example.exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "123qwerty";
        String pass = "qwerty_321";
        String confirmPass = "qwerty_321";
        System.out.println(acceptThreeParameters(login, pass, confirmPass));
    }

    public static boolean acceptThreeParameters(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLengthPass;
        boolean checkLengthLogin;
        boolean checkPasswordMatching;
        try {
            checkLengthLogin = checkLengthLogin(login);
            checkLengthPass = checkLengthPassword(password);
            checkPasswordMatching = checkPasswordMatching(password, confirmPassword);
            checkLogin = checkValidationCharacter(login);
            checkPassword = checkValidationCharacter(password);
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return checkLogin && checkPassword && checkLengthPass && checkLengthLogin && checkPasswordMatching;
    }

    public static boolean checkValidationCharacter(String checkWord) {
        if (checkWord == null) {
            throw new NullPointerException(" поле не может быть пустым ! ");
        }
        if (checkWord.matches("\\w*")) {
            return true;
        }
        System.out.printf(" Недопустимые символы в строке - '%s'\n", checkWord);
        return false;
    }

    public static boolean checkLengthLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException(" слишком длинный логин ");
        }
        return true;
    }

    public static boolean checkLengthPassword(String pass) throws WrongPasswordException {
        if (pass.length() > 19) {
            System.out.println(" превышена длина пароля ");
            return false;
        }
        return true;
    }

    public static boolean checkPasswordMatching(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException(" пароль не совпадает ");
    }
}