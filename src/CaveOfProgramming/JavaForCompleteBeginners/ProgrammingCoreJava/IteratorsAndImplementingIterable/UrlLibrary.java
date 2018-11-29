package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.IteratorsAndImplementingIterable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {
    private LinkedList<String> urls = new LinkedList<String>();

    //Inner class that implements Iterator
    private class UrlIterator implements Iterator<String> {
        //We need a sense of where the iterator is currently pointing, so an instance variable called index
        private int index = 0;

        @Override
        public boolean hasNext() {
            //We have 3 String elements currently stored in the urls LinkedList<String>; if the index is 0,1,2 we have elements still.
            return index < urls.size();
        }

        @Override
        public String next() {
            StringBuilder sb = new StringBuilder();

            try {
                URL url = new URL(urls.get(index));

                BufferedReader br = new BufferedReader( new InputStreamReader(url.openStream()) );

                String line = null;

                while ( (line = br.readLine()) != null ) {
                    sb.append(line);
                    sb.append("\n");
                }

                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            index++;

            return sb.toString();
        }

        @Override
        public void remove() {
            urls.remove(index);
        }
    }

    public UrlLibrary() {
        urls.add("http://www.caveofprogramming.com");
        urls.add("http://www.facebook.com/caveofprogramming");
        urls.add("http://news.bbc.co.uk");
    }

    //Now we're going to write our own from scratch rather than using LinkedList's iterator() method (see below).
    @Override
    public Iterator<String> iterator() {
        return new UrlIterator();
    }

    /*  //Using LinkedList's iterator() method.
    @Override
    public Iterator<String> iterator() {
        return urls.iterator();
    }
    */
}
