package marumasa.sunday_cmd.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class SundayClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // コマンド登録処理
        ClientCommandRegistrationCallback.EVENT.register((clientCommandSourceCommandDispatcher, commandRegistryAccess) -> Command.register(clientCommandSourceCommandDispatcher));
    }
}
