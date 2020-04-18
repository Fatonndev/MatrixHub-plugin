package matrixHub;

import arc.Events;
import arc.net.Server;
import arc.util.*;

import matrixHub.utils.*;

import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.gen.Call;
import mindustry.plugin.Plugin;

public class Main extends Plugin{

    public Main() {

        Config.main();
        Upd.main();
        //Upd.Update();

        Events.on(ServerLoadEvent.class, event -> {
            Vars.netServer.admins.addActionFilter(playerAction -> false);
            Call.onLabel(ConfigTranslate.get("server1.title"), 1100f, 487f, 306f);
        });

        Events.on(PlayerJoin.class, event -> {

            Call.onLabel(event.player.con, ConfigTranslate.get("server4.title"), 1100f, 508f, 304f);
            Call.onLabel(event.player.con, ConfigTranslate.get("server3.title"), 1100f, 284f, 304f);
            Call.onLabel(event.player.con, ConfigTranslate.get("server2.title"), 1100f, 508f, 529f);
            Call.onLabel(event.player.con, ConfigTranslate.get("server1.title"), 1100f, 284f, 529f);

            Vars.net.pingHost(Config.get("ip1"), Integer.parseInt(Config.get("port1")), host -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.online").replace("{0}", String.valueOf(host.players)), 1100f, 284f, 490f);
            }, e -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.offline"), 1100f, 284f, 490f);
            });

            Vars.net.pingHost(Config.get("ip2"), Integer.parseInt(Config.get("port2")), host -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.online").replace("{0}", String.valueOf(host.players)), 1100f, 508f, 490f);
            }, e -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.offline"), 1100f, 508f, 490f);
            });

            Vars.net.pingHost(Config.get("ip3"), Integer.parseInt(Config.get("port3")), host -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.online").replace("{0}", String.valueOf(host.players)), 1100f, 284f, 265f);
            }, e -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.offline"), 1100f, 280f, 265f);
            });

            Vars.net.pingHost(Config.get("ip4"), Integer.parseInt(Config.get("port4")), host -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.online").replace("{0}", String.valueOf(host.players)), 1100f, 508f, 265f);
            }, e -> {
                Call.onLabel(event.player.con, ConfigTranslate.get("server.offline"), 1100f, 508f, 265f);
            });

        });
    }

    @Override
    public void registerServerCommands(CommandHandler handler){
        handler.register("ping", "Return \"Pong!\"", args -> { Log.info("Pong!");});
    }

}

