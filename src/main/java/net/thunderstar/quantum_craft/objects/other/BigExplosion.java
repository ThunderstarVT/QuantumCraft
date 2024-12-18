package net.thunderstar.quantum_craft.objects.other;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigExplosion extends Explosion {
    protected Level level;
    protected double x;
    protected double y;
    protected double z;
    protected double radius;
    protected double power;
    protected Random random = new Random();

    public BigExplosion(Level level, @Nullable Entity entity, @Nullable DamageSource damage_source, @Nullable ExplosionDamageCalculator explosion_damage_calculator, double x, double y, double z, double power, BlockInteraction blockInteraction) {
        super(level, entity, damage_source, explosion_damage_calculator, x, y, z, (float) (4.7 * Math.pow(power, (double) 1 /6)), false, blockInteraction);

        this.level = level;
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = 4.7 * Math.pow(power, (double) 1 /6);
        this.power = power;
    }

    private int current_radius = 0;

    @Override
    public void explode() {
        //TODO: explode one shell per tick
    }

    @Override
    public void finalizeExplosion(boolean p_46076_) {

    }

    public static double radiusToPower(double max_radius, double current_radius) {
        double radius_difference = max_radius - current_radius;
        if (radius_difference <= 0) {
            return 0;
        } else {
            return (radius_difference / 4.7)*(radius_difference / 4.7)*(radius_difference / 4.7)*(radius_difference / 4.7)*(radius_difference / 4.7)*(radius_difference / 4.7);
        }
    }

    public static List<BlockPos> blockShell(Level level, double outer_radius, double inner_radius, BlockPos origin) {
        List<BlockPos> toReturn = new ArrayList<>();

        int origin_x = origin.get(Direction.Axis.X);
        int origin_y = origin.get(Direction.Axis.Y);
        int origin_z = origin.get(Direction.Axis.Z);

        for (int X = origin_x - (int)Math.ceil(outer_radius); X < origin_x + (int)Math.ceil(outer_radius); X++) {
            for (int Y = Math.max(origin_y - (int)Math.ceil(outer_radius), -63); Y < Math.min(origin_y + (int)Math.ceil(outer_radius), 320); Y++) {
                for (int Z = origin_z - (int)Math.ceil(outer_radius); Z < origin_z + (int)Math.ceil(outer_radius); Z++) {
                    if (!(
                            X < origin_x + inner_radius && X > origin_x - inner_radius
                            && Y < origin_y + inner_radius && Y > origin_y - inner_radius
                            && Z < origin_z + inner_radius && Z > origin_z - inner_radius
                        ))
                    {
                        BlockPos pos = BlockPos.containing(X, Y, Z);
                        BlockState state = level.getBlockState(pos);
                        if (!state.isAir()) {
                            double dist_sq = (X - origin_x)*(X - origin_x) + (Y - origin_y)*(Y - origin_y) + (Z - origin_z)*(Z - origin_z);
                            if (dist_sq >= inner_radius*inner_radius && dist_sq <= outer_radius*outer_radius) {
                                toReturn.add(pos);
                            }
                        }
                    }
                }
            }
        }

        return toReturn;
    }
}
