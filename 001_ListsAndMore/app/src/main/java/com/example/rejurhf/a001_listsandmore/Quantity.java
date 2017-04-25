package com.example.rejurhf.a001_listsandmore;

import java.text.DecimalFormat;

/**
 * Created by Rejurhf on 25.04.2017.
 */

public class Quantity {
    final double value;
    final Unit unit;

    public static enum Unit{
        metres(1.0d), mile(0.0006d), inch(39.37d), feet(3.2808d), yard(1.0936d), staja(0.0002d);
        final static Unit baseUnit = metres;
        final double byBaseUnit;

        private Unit(double inMetres){ this.byBaseUnit = inMetres; }

        private double toBaseUnit(double value){ return value / byBaseUnit; }

        private double fromBaseUnit(double value){ return value * byBaseUnit; }
    }

    public Quantity(double value, Unit newUnit){
        Unit oldUnit = this.unit;
        return new Quantity(newUnit.fromBaseUnit(oldUnit.toBaseUnit(value)), newUnit);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0000");
        return df.format(value);
    }
}
