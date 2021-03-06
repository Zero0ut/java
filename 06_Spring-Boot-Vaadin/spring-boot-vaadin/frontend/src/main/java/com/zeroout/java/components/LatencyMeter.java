package com.zeroout.java.components;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.time.Instant;

@Push
public class LatencyMeter extends UI {

    Label label = new Label( "Now : " );
    Button button = null;

    @Override
    protected void init ( VaadinRequest vaadinRequest )
    {
        // Prepare widgets.
        this.button = this.makeOpenWindowButton();

        // Arrange widgets in a layout.
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin( Boolean.TRUE );
        layout.setSpacing( Boolean.TRUE );
        layout.addComponent(this.label, 1);
        layout.addComponent(this.button, 2);

        // shorthand methods for changing the component theme variants
        //layout.setPadding(false);
        layout.setMargin(true);
        // just a demonstration of the API, by default the spacing is on
        layout.setSpacing(true);

        // Put layout in this UI.
        setContent( layout );

        // Start the data feed thread
        new FeederThread().start();
    }

    @WebServlet( urlPatterns = "/*" , name = "MyUIServlet" , asyncSupported = true )
    @VaadinServletConfiguration( ui = MyUI.class , productionMode = false )
    public static class MyUIServlet extends VaadinServlet
    {
    }

    public void tellTime ()
    {
        label.setValue( "Now : " + Instant.now().toString() ); // If before Java 8, use: new java.util.Date(). Or better, Joda-Time.
    }

    class FeederThread extends Thread
    {

        // This Thread class is merely a simple test to verify that Push works.
        // This Thread class is not the intended example.
        // A ScheduledExecutorService is in WebAppListener class is the intended example.
        int count = 0;

        @Override
        public void run ()
        {
            try {
                // Update the data for a while
                while ( count < 100 ) {
                    Thread.sleep( 1000 );

                    access( new Runnable() // Special 'access' method on UI object, for inter-thread communication.
                    {
                        @Override
                        public void run ()
                        {
                            count ++;
                            tellTime();
                        }
                    } );
                }

                // Inform that we have stopped running
                access( new Runnable()
                {
                    @Override
                    public void run ()
                    {
                        label.setValue( "Done. No more telling time." );
                    }
                } );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    Button makeOpenWindowButton ()
    {
        // Create a button that opens a new browser window.
        BrowserWindowOpener opener = new BrowserWindowOpener( DataUI.class );
        opener.setFeatures( "height=300,width=440,resizable=yes,scrollbars=no" );

        // Attach it to a button
        Button button = new Button( "Open data window" );
        opener.extend( button );

        return button;
    }
}
