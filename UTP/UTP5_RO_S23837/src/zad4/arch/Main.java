///**
// *
// *  @author Ratus Oskar S23837
// *
// */
//
//package zad4;
//
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicReference;
//
//
//public class Main {
//
//  public static void main(String[] args) {
//      Towar towar = new Towar();
//
//      new Thread(() -> {
//          AtomicInteger count = new AtomicInteger(0);
//          try {
//              Files.readAllLines(Paths.get("..\\Towary.txt"))
//                      .stream()
//                      .forEach(str -> {
//                          towar.setValues(str.split(" ")[0], str.split(" ")[1]);
//                          count.incrementAndGet();
//                          if ((count.intValue()%200) == 0)
//                              System.out.println("utworzono " + count.intValue() + " obiektów");
//                      });
//          } catch (IOException e) {
//
//          }
//      }).start();
//
//
//
//
//  }
//
//}
//
//class Towar{
//  private String id_towaru;
//  private double waga;
//  private boolean isLocked = true;
//
//  public synchronized String getId_towaru(){
//      while (isLocked){
//          try {
//              wait();
//          } catch (InterruptedException e) {
//
//          }
//      }
//      isLocked = false;
//      notifyAll();
//      return id_towaru;
//  }
//
//  public synchronized Double getWaga(){
//      while (isLocked){
//          try {
//              wait();
//          } catch (InterruptedException e) {
//
//          }
//      }
//      isLocked = true;
//      notifyAll();
//      return waga;
//  }
//
//  public synchronized void setValues(String s, String w){
//      while (!isLocked){
//          try {
//              wait();
//          } catch (InterruptedException e) {
//
//          }
//      }
//      this.id_towaru = s;
//      this.waga = Double.parseDouble(s);
//      isLocked = false;
//      notifyAll();
//  }
//}
//
