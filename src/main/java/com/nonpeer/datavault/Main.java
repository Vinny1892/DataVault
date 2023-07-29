package com.nonpeer.datavault;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var isGui =  Arrays.stream(args).anyMatch(arg -> arg.equals("-g") || arg.equals("--gui"));
        if(isGui){
            HelloApplication.main(args);
        }
        System.out.println("Iniciando Aplicação");
    }
}
