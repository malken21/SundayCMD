package marumasa.sunday_cmd.client;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class Command {

    public static void register(CommandDispatcher<FabricClientCommandSource> clientCommandSourceCommandDispatcher) {
        clientCommandSourceCommandDispatcher.register(
                ClientCommandManager.literal("sunday")
                        .executes(Command::run)
        );
    }

    private static int run(CommandContext<FabricClientCommandSource> context) {
        ClientPlayNetworkHandler net = MinecraftClient.getInstance().getNetworkHandler();
        if (net == null) return -1;
        net.sendCommand("sun");
        net.sendCommand("day");
        return 1;
    }
}
