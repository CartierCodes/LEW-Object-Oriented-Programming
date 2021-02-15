/*
 * @author Carter Burzlaff
 * 
 * This file is part of the SwissArmyKnife (sak) project
 * 
 * This application uses the open source component HttpRequest.java
 */

 public class sak
 {
     public static void main(String[] args)
     {
         float start;
         float end;

         if (args.length < 1)
         {
            getHelp();
         }

         else if (args[0].equalsIgnoreCase("-Help"))
         {
            start = System.nanoTime();
            System.out.println("Running Help...");
            getHelp();
            end = System.nanoTime();
            System.out.format("-Help took %f seconds to run", (end - start) / 1000000000);
         }

         else if (args[0].equalsIgnoreCase("-HttpRequest"))
         {
            System.out.println("Running -HttpRequest...");
            start = System.nanoTime();
            if (args.length < 2)
            {
               System.out.println("-HttpRequest must be followed by a URL");
            }
            else
            {
               String URL = args[1];
               HttpRequest request = new HttpRequest();
               if (request.readURL(URL)) { System.out.println(request); }
            }
            end = System.nanoTime();
            System.out.format("-HttpRequest took %f seconds to run", (end - start) / 1000000000);
         }

         else if (args[0].equalsIgnoreCase("-HttpRequestIndex"))
         {
            System.out.println("Running -HttpRequestIndex...");
            start = System.nanoTime();
            if (args.length < 2)
            {
               System.out.println("-HttpRequestIndex must be followed by a URL");
            }
            else
            {
               String URL = args[1];
               HttpRequestIndex request = new HttpRequestIndex();
               if (request.readURL(URL)) { System.out.println(request); }
            }
            end = System.nanoTime();
            System.out.format("-HttpRequest took %f seconds to run", (end - start) / 1000000000);
         }
     }

     private static void getHelp()
     {
        System.out.println("\nThis program requires the use of command line functions, please see examples below:");
        System.out.println("\nHelp menu:");
        System.out.println("java sak -Help");
        System.out.println("\nHttpRequest examples:");
        System.out.println("java sak -HttpRequest https://www.coolmathgames.com");
        System.out.println("java sak -HttpRequest https://www.youtube.com");
        System.out.println("java sak -HttpRequest https://www.amazon.com");
        System.out.println("\nHttpRequestIndex examples:");
        System.out.println("java sak -HttpRequestIndex https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
     }
 }