package com.dotmarketing.osgi.hooks;

import com.dotcms.repackage.org.osgi.framework.BundleContext;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.osgi.GenericBundleActivator;
import com.dotmarketing.portlets.contentlet.business.ContentletAPI;

/**
 * Created by Jonathan Gamba
 * Date: 6/18/12
 */
public class Activator extends GenericBundleActivator {

    @SuppressWarnings ("unchecked")
    public void start ( BundleContext context ) throws Exception {

        //Initializing services...
        initializeServices ( context );

        //Adding hooks
        addPreHook( Class.forName( SamplePreContentHook.class.getName() ).newInstance() );
        addPostHook( Class.forName( SamplePostContentHook.class.getName() ).newInstance() );

        //Testing the hooks
        ContentletAPI conAPI = APILocator.getContentletAPI();

        Long count = conAPI.contentletCount();
        System.out.println( "+++++++++++++++++++++++++++++++++++++++++++++++" );
        System.out.println( "ContentletAPI.contentletCount() = " + count );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++++++++++" );
    }

    public void stop ( BundleContext context ) throws Exception {
        unregisterServices( context );
    }

}