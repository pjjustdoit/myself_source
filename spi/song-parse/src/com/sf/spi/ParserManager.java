package com.sf.spi;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;


public class ParserManager {
	
	private final static CopyOnWriteArrayList<ParserInfo> registeredParsers = new CopyOnWriteArrayList<>();

    static {
        loadInitialParsers();
        System.out.println("SongParser initialized");
    }
    
    private static void loadInitialParsers() {
        ServiceLoader<Parser> loadedParsers = ServiceLoader.load(Parser.class);
        Iterator<Parser> driversIterator = loadedParsers.iterator();
        try{
            while(driversIterator.hasNext()) {
                Parser parser = driversIterator.next();
            }
        } catch(Throwable t) {
            System.out.println(t);
        }
    }
    
    public static synchronized void registerParser(Parser parser) {
        registeredParsers.add(new ParserInfo(parser));
    }

    public static Song getSong(byte[] data) {
        for (ParserInfo parserInfo : registeredParsers) {
            try {
                Song song = parserInfo.parser.parse(data);
                if (song != null) {
                    return song;
                }
            } catch (Exception e) {
                //wrong parser, ignored it.
            }
        }
        return null;
//        throw new Exception("Can not find corresponding data:" + new String(data));
    }
}
