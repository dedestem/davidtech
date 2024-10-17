package net.davidnet.davidtech;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.davidnet.davidtech.items.ModItems;
import net.davidnet.davidtech.blocks.ModBlocks;

import java.util.HashSet;
import java.util.Set;

public class Davidtech implements ModInitializer {
	public static final String MOD_ID = "davidtech";

	// Logger for the mod
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Set to keep track of players who have received the questbook
	private final Set<String> playersGivenQuestbook = new HashSet<>();

	@Override
	public void onInitialize() {
		LOGGER.info("Welcome {} to Fabric!", MOD_ID);

		LOGGER.info("Registering Items!");
		ModItems.registerAll();

		LOGGER.info("Registering Item Groups");
		ModItems.registerItemGroupEntries();

		LOGGER.info("Registering Blocks!");
		ModBlocks.registerAll();

		// Register the server tick event
		ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
	}

	private void onServerTick(MinecraftServer server) {
		// Iterate over all players on the server
		server.getPlayerManager().getPlayerList().forEach(player -> {
			// Check if the player has already been given the quest book
			if (!playersGivenQuestbook.contains(player.getUuidAsString())) {
				giveQuestBookToPlayer(player);
			}
		});
	}

	private void giveQuestBookToPlayer(ServerPlayerEntity player) {
		// Create the quest book item
		ItemStack questBook = new ItemStack(ModItems.GetItemByID("ftbquests", "book"));

		// Check if the player's inventory already contains the quest book
		if (!player.getInventory().contains(questBook)) {
			player.getInventory().insertStack(questBook);
			LOGGER.info("Gave questbook to {}", player.getName().getString());

			// Mark the player as having received the quest book
			playersGivenQuestbook.add(player.getUuidAsString());
		}
	}
}
