package com.aimsk.pcd.experiments;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet  {

    public static void main(String[] args) throws UnknownHostException {

        //if(args.length != 1)
          //  System.exit(1);

        InetAddress a = InetAddress.getByName("store.steampowered.com");
        System.out.println(a);
    }
}
