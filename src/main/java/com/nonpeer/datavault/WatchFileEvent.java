package com.nonpeer.datavault;

import java.io.IOException;
import java.nio.file.*;

public class WatchFileEvent implements  Runnable {

    @Override
    public void run() {
        String diretorioObservado = "C:\\Users\\vinny\\teste";

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            Path diretorioPath = Paths.get(diretorioObservado);
            diretorioPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("estamos na thread do file watch event");
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                key.pollEvents().forEach((event) -> {
                    var kind = event.kind();
                    Path nomeItem = (Path) event.context();
                    System.out.println(kind);
                    System.out.println("Item alterado: " + nomeItem);
                });

                key.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
