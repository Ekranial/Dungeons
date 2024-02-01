package lycoris.dungeons.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobSpawner {

    public static void dg1_1(Player player) {
        for (int i = 0; i < 3; i++) {
            LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(new Location(player.getWorld(), -30.5, 101, -9.5), EntityType.ZOMBIE);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));

            entity = (LivingEntity) player.getWorld().spawnEntity(new Location(player.getWorld(), -44.5, 101, -6.5), EntityType.ZOMBIE);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));

            entity = (LivingEntity) player.getWorld().spawnEntity(new Location(player.getWorld(), -39.5, 101, 11.5), EntityType.ZOMBIE);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));
        }

        LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(new Location(player.getWorld(), -30.5, 101, 11.5), EntityType.SKELETON);
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, -1, 2));

        entity = (LivingEntity) player.getWorld().spawnEntity(new Location(player.getWorld(), -30.5, 101, 11.5), EntityType.ZOMBIE);
        entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));
    }

    public static void dg1_2(World world) {
        for (int i = 0; i < 5; i++) {
            LivingEntity entity = (LivingEntity) world.spawnEntity(new Location(world, -30.5, 101, -9.5), EntityType.ZOMBIE);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));

            entity = (LivingEntity) world.spawnEntity(new Location(world, -44.5, 101, -6.5), EntityType.ZOMBIE);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));

            entity = (LivingEntity) world.spawnEntity(new Location(world, -39.5, 101, 11.5), EntityType.ZOMBIE);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, -1, 1));
        }

        for (int i = 0; i < 4; i++) {
            LivingEntity entity = (LivingEntity) world.spawnEntity(new Location(world, -30.5, 101, 11.5), EntityType.SKELETON);
            entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, -1, 2));
        }
    }

}
