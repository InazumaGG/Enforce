package gg.inazuma.enforce.command;

import ac.grim.grimac.GrimAPI;
import ac.grim.grimac.command.BuildableCommand;
import ac.grim.grimac.platform.api.manager.cloud.CloudPlatformCommandArguments;
import ac.grim.grimac.platform.api.sender.Sender;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.incendo.cloud.CommandManager;

public final class EnforceVersion implements BuildableCommand {
    @Override
    public void register(CommandManager<Sender> commandManager, CloudPlatformCommandArguments arguments) {
        commandManager.command(commandManager.commandBuilder("enforce", "grim", "grimac")
                .literal("version")
                .permission("grim.version")
                .handler(context -> {
                    context.sender().sendMessage(Component.text("Enforce "
                            + GrimAPI.INSTANCE.getExternalAPI().getGrimVersion(), NamedTextColor.AQUA));
                    context.sender().sendMessage(Component.text("Based on GrimAC; maintained by InazumaGG.", NamedTextColor.GRAY));
                    context.sender().sendMessage(Component.text("https://github.com/InazumaGG/Enforce", NamedTextColor.GRAY)
                            .clickEvent(ClickEvent.openUrl("https://github.com/InazumaGG/Enforce")));
                }));
    }
}
