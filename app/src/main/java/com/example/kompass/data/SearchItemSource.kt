package com.example.kompass.data

import com.example.kompass.R
import com.example.kompass.types.Category
import com.example.kompass.types.ContentsCard
import com.example.kompass.types.DimensionInfo
import com.example.kompass.types.ProductItem
import com.example.kompass.types.SustainabilityInfo

class SearchItemSource {
    fun loadSearchItems(): List<ProductItem> {
        return listOf<ProductItem>(
            ProductItem("SÄBOVIK", "693.857.50", "Divan Bed", 3795, Category.BEDS_AND_MATTRESSES_S_BEDS, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(5, listOf("Polyester", "Steel", "Wood"), listOf("Sweden", "Sweden", "Norway")), R.drawable.sabovik),
            ProductItem("SKOTTERUD", "203.073.20", "Mattress", 2595,Category.BEDS_AND_MATTRESSES_S_MATTRESSES, DimensionInfo(205, 95, 60, 200, 90), SustainabilityInfo(15, listOf("Cotton", "Polyester", "Steel"), listOf("Spain", "Sweden", "Norway")), R.drawable.skotterud),
            ProductItem("Malm", "591.759.55", "Bed Frame", 2395, Category.BEDS_AND_MATTRESSES_S_BED_FRAMES, DimensionInfo(209, 156, 100, 200, 140), SustainabilityInfo(7, listOf("Foil", "Galvanized Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.malm),
            ProductItem("Slattum", "405.712.48", "Bed Frame", 1495, Category.BEDS_AND_MATTRESSES, DimensionInfo(206, 164, 85, 200, 160), SustainabilityInfo(12, listOf("Foil", "Polyester", "Wood"), listOf("Denmark", "Germany", "Norway")), R.drawable.slattum),
            ProductItem("EKOLN","704.930.13","Waste bin",99, Category.BATHROOM_FURNITURE_S_BATHROOM_ACCESSORIES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.ekoln)
            ProductItem("SÄBOVIK", "693.857.50", "Divan Bed", 3795, Category.BEDS_AND_MATTRESSES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(5, listOf("Polyester", "Steel", "Wood"), listOf("Sweden", "Sweden", "Norway")), listOf(
                ContentsCard("1 x Divan Bed", "140x200 cm", "SÄBOVIK", R.drawable.sabovik_divanbed), ContentsCard("1 x Mattress", "140x200 cm", "SÄBOVIK", R.drawable.sabovik_mattress)
            ), "Fabric:\n" +
                    "100% polyester (min. 90% recycled)\n" +
                    "\n" +
                    "Headboard:\n" +
                    "100 % polyester, Polyester wadding, Steel, Polyurethane foam 20 kg/cu.m.\n" +
                    "\n" +
                    "Footboard:\n" +
                    "Steel\n" +
                    "\n" +
                    "Bedside:\n" +
                    "100 % polyester, Particleboard, Steel\n" +
                    "\n" +
                    "Midbeam/ Cross rail/ Leg:\n" +
                    "Steel, Epoxy/polyester powder coating\n" +
                    "\n" +
                    "Lining:\n" +
                    "100% polypropylene", "Mattress and slatted bed base included.\n" +
                    "\n" +
                    "Mattress pad included.\n" +
                    "\n" +
                    "Legs included.\n" +
                    "\n" +
                    "Headboard included.\n" +
                    "\n" +
                    "Bed linen sold separately.", R.drawable.sabovik),
            ProductItem("SKOTTERUD", "203.073.20", "Mattress", 2595,Category.BEDS_AND_MATTRESSES, DimensionInfo(205, 95, 60, 200, 90), SustainabilityInfo(15, listOf("Cotton", "Polyester", "Steel"), listOf("Spain", "Sweden", "Norway")), emptyList(),
              "Frame:\n" +
                      "Solid pine, Solid spruce, Plywood\n" +
                      "\n" +
                      "Protection weave/ Lining:\n" +
                      "Non-woven polypropylene\n" +
                      "\n" +
                      "Double welded pocket spring unit/ Bonell spring unit/ Metal frame:\n" +
                      "Steel\n" +
                      "\n" +
                      "Corner protection:\n" +
                      "Polyurethane foam 25 kg/cu.m.\n" +
                      "\n" +
                      "Ticking:\n" +
                      "64% polyester, 36% cotton\n" +
                      "\n" +
                      "Ticking, side/ Ticking:\n" +
                      "64% cotton, 36% polyester\n" +
                      "\n" +
                      "Comfort material:\n" +
                      "Polyester wadding\n" +
                      "\n" +
                      "Ticking:\n" +
                      "64% cotton, 36 % polyester (100% recycled)", "To be completed with SULTAN connection fitting if you place two wooden base sprung mattresses next to each other; this will prevent them from sliding apart.\n" +
                        "\n" +
                        "Sometimes the mattress has a noticeable smell when you open the packaging. The smell isn’t harmful or toxic and disappears over time. Airing and vacuuming the mattress helps to eliminate the smell faster.\n" +
                        "\n" +
                        "All of our mattresses can be used immediately, but keep in mind that a packaged mattress only regains its full shape and comfort after approximately 72 hours. Your body also needs a couple of weeks to adapt to the new mattress.\n" +
                        "\n" +
                        "194 pocket springs/sq.m.\n" +
                        "\n" +
                        "Legs are sold separately.\n" +
                        "\n" +
                        "Bed linen sold separately.\n" +
                        "\n" +
                        "Mattress pad sold separately."  ,R.drawable.skotterud),
            ProductItem("MALM", "591.759.55", "Bed Frame", 2395, Category.BEDS_AND_MATTRESSES, DimensionInfo(209, 156, 100, 200, 140), SustainabilityInfo(7, listOf("Foil", "Galvanized Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), listOf(
                ContentsCard("1 x Bed Frame, high", "140x200 cm", "MALM", R.drawable.malm_bedframe), ContentsCard("1 x Midbeam", "", "SKORVA", R.drawable.malm_skorva_midbeam), ContentsCard("1 x Bed Storage Box", "200 cm", "MALM", R.drawable.malm_bedstoragebox)
            ),"Bed frame, high\n" +
                    "\n" +
                    "Head/footboard:\n" +
                    "Particleboard, Fibreboard, Fibreboard, Printed and embossed acrylic paint, Plastic edging, Honeycomb structure paper filling (100% recycled)\n" +
                    "\n" +
                    "Bedside:\n" +
                    "Particleboard, Fibreboard, Printed and embossed acrylic paint, Paper, Plastic edging\n" +
                    "\n" +
                    "Midbeam\n" +
                    "\n" +
                    "Galvanized steel\n" +
                    "\n" +
                    "Bed storage box for high bed frame\n" +
                    "\n" +
                    "Drawer side/ Drawer back:\n" +
                    "Particleboard, Foil\n" +
                    "\n" +
                    "Drawer bottom:\n" +
                    "Particleboard, Laminate (melamine), ABS plastic\n" +
                    "\n" +
                    "Drawer front:\n" +
                    "Particleboard, Fibreboard, Printed acrylic paint, ABS plastic, Paper", "SKORVA midbeam is included in the price but packaged separately. It is required for the stability of the bed frame and to keep mattresses in place.\n" +
                    "\n" +
                    "Slatted bed base, mattress and bedlinen are sold separately.", R.drawable.malm),
            ProductItem("SLATTUM", "405.712.48", "Bed Frame", 1495, Category.BEDS_AND_MATTRESSES, DimensionInfo(206, 164, 85, 200, 160), SustainabilityInfo(12, listOf("Foil", "Polyester", "Wood"), listOf("Denmark", "Germany", "Norway")), emptyList(), "Fabric:\n" +
                    "100% polyester (min. 90% recycled)\n" +
                    "\n" +
                    "Headboard:\n" +
                    "100 % polyester, Polyester wadding, Steel, Polyurethane foam 20 kg/cu.m.\n" +
                    "\n" +
                    "Footboard:\n" +
                    "Steel\n" +
                    "\n" +
                    "Bedside:\n" +
                    "100 % polyester, Particleboard, Steel\n" +
                    "\n" +
                    "Midbeam/ Cross rail/ Leg:\n" +
                    "Steel, Epoxy/polyester powder coating\n" +
                    "\n" +
                    "Lining:\n" +
                    "100% polypropylene", "Slatted bed base and midbeam are included.\n" +
                    "\n" +
                    "Mattress and bedlinen are sold separately.\n" +
                    "\n" +
                    "The back of the headboard is finished with a black non-woven material.", R.drawable.slattum),


        )
    }
}

/*
            ProductItem("LUMIÖR", "203.073.20", "Pendant Light", 2595,Category.LIGHTING, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_basic_materials),
            ProductItem("FÄRGFUL","203.073.20", "Throw Blanket", 2595, Category.TEXTILES, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_user),
            ProductItem("RUMTÄM", "203.073.20", "Storage Box", 2595, Category.STORAGE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.menu_main_sustainability),
            ProductItem("SKRIVNA", "203.073.20", "Wall Shelf", 2595,Category.FURNITURE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_qr),
            ProductItem("KÖKSTID", "203.073.20", "Tableware Set", 2595,Category.KITCHENWARE, DimensionInfo(204, 140, 90, 200, 140), SustainabilityInfo(12, listOf("Cotton", "Steel", "Wood"), listOf("Spain", "Sweden", "Norway")), R.drawable.navbar_search)
 */

