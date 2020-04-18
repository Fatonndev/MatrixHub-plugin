package matrixHub.utils;

import arc.util.Log;
import mindustry.Vars;
import mindustry.entities.type.Player;
import mindustry.gen.Call;

import java.util.logging.Level;

public class Upd {

    public static Player player;
    public static int id = 0;

    public static void main() {
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(50);

                        if(Vars.playerGroup.all().size != 0 && id+1 <= Vars.playerGroup.all().size) {

                            player = Vars.playerGroup.all().get(id);

                                if (Vars.playerGroup.all().size-1 > id) {
                                    id++;
                                } else {
                                    id = 0;
                                }

                            if(Boolean.parseBoolean(Config.get("server1Works")))
                                if (player.x <= 306 && player.x >= 263 && player.y >= 488 && player.y <= 531) {

                                    Vars.net.pingHost(Config.get("ip1"), Integer.parseInt(Config.get("port1")), host -> {
                                        Call.onConnect(player.con, Config.get("ip1"), Integer.parseInt(Config.get("port1")));
                                        if(id!=0) id--;
                                    }, e -> {
                                    });

                                }

                            if(Boolean.parseBoolean(Config.get("server2Works")))
                                if (player.x >= 487 && player.x <= 528 && player.y >= 488 && player.y <= 531) {

                                    Vars.net.pingHost(Config.get("ip2"), Integer.parseInt(Config.get("port2")), host -> {
                                        Call.onConnect(player.con, Config.get("ip2"), Integer.parseInt(Config.get("port2")));
                                        if(id!=0) id--;
                                    }, e -> {
                                    });

                                }

                            if(Boolean.parseBoolean(Config.get("server3Works")))
                                if (player.x <= 306 && player.x >= 263 && player.y <= 306 && player.y >= 263) {

                                    Vars.net.pingHost(Config.get("ip3"), Integer.parseInt(Config.get("port3")), host -> {
                                        Call.onConnect(player.con, Config.get("ip3"), Integer.parseInt(Config.get("port3")));
                                        if(id!=0) id--;
                                    }, e -> {
                                    });
                                }

                            if(Boolean.parseBoolean(Config.get("server4Works")))
                                if (player.x >= 487 && player.x <= 528 && player.y <= 306 && player.y >= 263) {
                                    Vars.net.pingHost(Config.get("ip4"), Integer.parseInt(Config.get("port4")), host -> {
                                        Call.onConnect(player.con, Config.get("ip4"), Integer.parseInt(Config.get("port4")));
                                        if(id!=0) id--;
                                    }, e -> {
                                    });
                                }
                        }
                    }
                } catch (InterruptedException ignored) {
                    main();
                }
            }
        });
        th.start();
    }
}
