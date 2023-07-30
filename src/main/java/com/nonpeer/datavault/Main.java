package com.nonpeer.datavault;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        var isGui = Arrays.stream(args).anyMatch(arg -> arg.equals("-g") || arg.equals("--gui"));
        var isHelp = Arrays.stream(args).anyMatch(arg -> arg.equals("-h") || arg.equals("--help"));
        if(isHelp){
            if(isGui){
                System.out.println("HELP GUI");
            }else{
                System.out.println("HELP");
            }
            System.exit(0);
        }

        if(isGui){
            var guiManagement = new GuiManagement();
            var threadGui = new Thread(guiManagement);
            threadGui.start();
        }
            var fileWatchEvent = new WatchFileEvent();
            var threadFileWatchEvent = new Thread(fileWatchEvent);
            threadFileWatchEvent.start();

    }
}






















