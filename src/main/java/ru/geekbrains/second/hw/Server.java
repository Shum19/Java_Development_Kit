package ru.geekbrains.second.hw;

public class Server implements ServerListener {
    private boolean isServerWorking;
    private final ListenerServerFrame listenerServerFrame;
     Server(ListenerServerFrame listenerServerFrame){
         this.listenerServerFrame = listenerServerFrame;
         isServerWorking = false;

     }
     public void startServer(){
         if(!isServerWorking){
             isServerWorking = true;
             listenerServerFrame.messageReceived("Статус сервера запущен");
         }else
             listenerServerFrame.messageReceived("Сервер запущен");

     }
     public void stopServer(){
         if(isServerWorking){
             isServerWorking = false;
             listenerServerFrame.messageReceived("Статус сервера остановлен");
         }else
             listenerServerFrame.messageReceived("Сервер не запущен");

     }
     @Override
     public String getServerStatus(){
         return "Статус сервера: " + isServerWorking;
     }


    @Override
    public void serverListener(boolean status) {
         if (status){
             startServer();
         }else if (!status){
             stopServer();
         }

    }
}
