package com.elpiu.application.form.dto;

public interface Regexp {

    /**
     * Classe contenete le regular expression
     *
     * */
    //Supporta nome e cognome internazionali
    public static final String REG_NAME_SURNAME = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$";
    public static final String REG_NAME_SURNAME_MESSAGE = "Non può contenere numeri o caratteri speciali";

    //Password valida : pass123456.$A
    public static final String REG_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%'-\\/=^\\_`~+&])(?=.*[^0-9a-zA-Z]).{8,16}$";
    public static final String REG_PASSWORD_MESSAGE = "La password non è valida";

    //Userame valido : ciaoasd.j
    public static final String REG_USERNAME = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    public static final String REG_USERNAME_MESSAGE = "Username non valido";

    public static final String REG_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String REG_EMAIL_MESSAGE = "Email non valida";
}
