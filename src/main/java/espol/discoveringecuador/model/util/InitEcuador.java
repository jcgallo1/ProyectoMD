package espol.discoveringecuador.model.util;

import espol.discoveringecuador.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.codehaus.jackson.map.ObjectMapper;

public class InitEcuador {

    private static Comparator<Food> comparatorFood;
    private static Comparator<Province> comparatorProvince;
    private static Comparator<Region> comparatorRegion;
    public static Country getEcuador() {
        comparatorFood = getFoodComparator();
        comparatorProvince = getProvinceComparator();
        comparatorRegion = getRegionComparator();
        Region costa = generateCosta("COSTA");
        Region sierra = generateSierra("SIERRA");
        Region oriente = generateOriente("ORIENTE");
        Region insular = generateInsular("INSULAR");

        ArrayList<Region> regions = new ArrayList<>();
        regions.add(costa);
        regions.add(sierra);
        regions.add(oriente);
        regions.add(insular);
        Set<Region> set_regions = new TreeSet<>(comparatorRegion);
        set_regions.addAll(regions);
        Country Ecuador = new Country(set_regions);
        return Ecuador;
    }

    private static Comparator<Food> getFoodComparator() {
        Comparator<Food> comparatorFood = new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                return f1.getName().compareTo(f2.getName());
            }
        };
        return comparatorFood;
    }

    private static Comparator<Region> getRegionComparator() {
        Comparator<Region> comparator = new Comparator<Region>() {
            @Override
            public int compare(Region f1, Region f2) {
                return f1.getName().compareTo(f2.getName());
            }
        };
        return comparator;
    }

    private static Comparator<Province> getProvinceComparator() {
        Comparator<Province> comparatorProvince = new Comparator<Province>() {
            @Override
            public int compare(Province p1, Province p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
        return comparatorProvince;
    }

    public static Region generateInsular(String name) {
        ArrayList<String> provinces = new ArrayList<>();
        provinces.add("Galapagos");

        ArrayList<ArrayList<Food>> food = new ArrayList<>();
        ArrayList<Food> province_food = new ArrayList<>();
        province_food.add(new Food("Arroz marinero"));
        province_food.add(new Food("Bacalao con papas"));
        province_food.add(new Food("Ceviche de canchalagua"));
        province_food.add(new Food("Mariscos"));
        province_food.add(new Food("Pan de yuca"));
        province_food.add(new Food("Sopa marinera"));
        food.add(province_food);
        return generateRegion(name, provinces, food, comparatorFood, comparatorProvince);
    }
    public static Region generateOriente(String name) {

        ArrayList<String> provinces = new ArrayList<>();

        provinces.add("Morona-Santiago");

        ArrayList<ArrayList<Food>> food = new ArrayList<>();

        ArrayList<Food> province_food_morona = new ArrayList<>();
        province_food_morona.add(new Food("Ayampaco"));
        food.add(province_food_morona);


        provinces.add("Napo");

        ArrayList<Food> province_food_napo = new ArrayList<>();
        province_food_napo.add(new Food("Masato"));
        food.add(province_food_napo);

        provinces.add("Orellana");


        ArrayList<Food> province_food_orellana = new ArrayList<>();
        province_food_orellana.add(new Food("Maito de carachama"));
        food.add(province_food_orellana);

        provinces.add("Pastaza");


        ArrayList<Food> province_food_pastaza = new ArrayList<>();
        province_food_pastaza.add(new Food("Ceviche volquetero"));
        food.add(province_food_pastaza);

        provinces.add("Sucumbios");


        ArrayList<Food> province_food_sucumbios = new ArrayList<>();
        province_food_sucumbios.add(new Food("Maito"));
        food.add(province_food_sucumbios);

        provinces.add("Zamora-Chinchipe");


        ArrayList<Food> province_food_zamora = new ArrayList<>();
        province_food_zamora.add(new Food("Ancas de rana"));
        food.add(province_food_zamora);


        return generateRegion(name, provinces, food, comparatorFood, comparatorProvince);
    }
    public static Region generateSierra(String name) {


        ArrayList<String> provinces = new ArrayList<>();

        ArrayList<ArrayList<Food>> food = new ArrayList<>();

        provinces.add("Azuay");
        ArrayList<Food> province_food_azuay = new ArrayList<>();
        province_food_azuay.add(new Food("Mote pillo"));
        food.add(province_food_azuay);


        provinces.add("Bolívar");

        ArrayList<Food> province_food_bolivar = new ArrayList<>();
        province_food_bolivar.add(new Food("Tortillas de tiesto"));
        food.add(province_food_bolivar);

        provinces.add("Cañar");

        ArrayList<Food> province_food_cañar = new ArrayList<>();
        province_food_cañar.add(new Food("Cascaritas"));
        food.add(province_food_cañar);

        provinces.add("Carchi");

        ArrayList<Food> province_food_carchi = new ArrayList<>();
        province_food_carchi.add(new Food("Cuy con papas"));
        food.add(province_food_carchi);

        provinces.add("Chimborazo");

        ArrayList<Food> province_food_chimborazo = new ArrayList<>();
        province_food_chimborazo.add(new Food("Ceviche de chocho"));
        food.add(province_food_chimborazo);

        provinces.add("Cotopaxi");

        ArrayList<Food> province_food_cotopaxi = new ArrayList<>();
        province_food_cotopaxi.add(new Food("Chugchucara"));
        food.add(province_food_cotopaxi);

        provinces.add("Imbabura");

        ArrayList<Food> province_food_imbabura = new ArrayList<>();
        province_food_imbabura.add(new Food("Fritada"));
        food.add(province_food_imbabura);


        return generateRegion(name, provinces, food, comparatorFood, comparatorProvince);
    }
    public static Region generateCosta(String name) {

        ArrayList<String> provinces = new ArrayList<>();
        ArrayList<ArrayList<Food>> food = new ArrayList<>();

        provinces.add("El Oro");

        ArrayList<Food> province_food_oro = new ArrayList<>();
        province_food_oro.add(new Food("Tigrillo"));
        food.add(province_food_oro);


        provinces.add("Esmeraldas");

        ArrayList<Food> province_food_esmeraldas = new ArrayList<>();
        province_food_esmeraldas.add(new Food("Encocado de camarón"));
        food.add(province_food_esmeraldas);

        provinces.add("Guayas");

        ArrayList<Food> province_food_gye = new ArrayList<>();
        province_food_gye.add(new Food("Cangrejo Criollo"));
        food.add(province_food_gye);

        provinces.add("Los Ríos");

        ArrayList<Food> province_food_rios = new ArrayList<>();
        province_food_rios.add(new Food("Bollo de pescado"));
        food.add(province_food_rios);

        provinces.add("Manabí");

        ArrayList<Food> province_food_manabi = new ArrayList<>();
        province_food_manabi.add(new Food("Tonga"));
        food.add(province_food_manabi);

        provinces.add("Santa Elena");

        ArrayList<Food> province_food_elena = new ArrayList<>();
        province_food_elena.add(new Food("Cazuela de mariscos"));
        food.add(province_food_elena);

        provinces.add("Santo Domingo de los Tsáchilas");

        ArrayList<Food> province_food_domingo = new ArrayList<>();
        province_food_domingo.add(new Food("Pandado"));
        food.add(province_food_domingo);


        return generateRegion(name, provinces, food, comparatorFood, comparatorProvince);
    }

    public static Set<Food> fillFood(ArrayList<Food> list, Comparator<Food> comparator) {
        Set<Food> tmp = new TreeSet<>(comparator);
        tmp.addAll(list);
        return tmp;
    }

    public static Set<Province> fillProvince(ArrayList<Province> list, Comparator<Province> comparator) {
        Set<Province> tmp = new TreeSet<>(comparator);
        tmp.addAll(list);
        return tmp;
    }

    public static Region generateRegion(String name, ArrayList<String> province_names, ArrayList<ArrayList<Food>> foods, Comparator<Food> comparatorFood, Comparator<Province> comparatorProvince) {
        // Region NAME
        // ------ PROVINCES
        ArrayList<Province> list_provinces = new ArrayList<>();
        for (int i = 0; i< foods.size(); i++) {
            Province tmp_province = new Province(province_names.get(i));
            tmp_province.setFood(fillFood(foods.get(i), comparatorFood));
            list_provinces.add(tmp_province);
        }

        Region tmp_region = new Region(name, fillProvince(list_provinces, comparatorProvince));
        return tmp_region;
    }


}
