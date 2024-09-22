package org.bot4j.telegram.model.enums;

@SuppressWarnings({"all"})
// @formatter:off
public enum TelegramIconMode {
    ERROR("\uD83D\uDD34"),
    SUCCESS("\uD83D\uDFE2"),
    WARN("\uD83D\uDFE1"),
    TRACE("\uD83D\uDCDC"),
    INFO("\uD83D\uDD35"),
    SOS("\uD83C\uDD98"),
    MESSAGE("\uD83D\uDCAC"),
    TS_1("\uD83C\uDFAF"),
    TS_2("\uD83D\uDDD3"),
    TS_3("\uD83D\uDCCD"),
    NOTIFY("\uD83D\uDCE3"),
    TADA("\uD83C\uDF89"),
    SETTING("\uD83D\uDD27"),
    ROCKET("\uD83D\uDE80"),
    KEY("\uD83D\uDD11"),
    BOT("\uD83E\uDD16"),
    USER("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB"),
    BUG_1("\uD83D\uDC1E"),
    BUG_2("\uD83D\uDC7E"),
    BUG_3("\uD83E\uDEB2"),
    BUG_4("\uD83D\uDC1B"),
    RIGHT_ARROW_1("\uD83D\uDC49"),
    LEFT_ARROW_1("\uD83D\uDC48"),
    THUMBS_UP("\uD83D\uDC4D"),             // Thumbs Up
    THUMBS_DOWN("\uD83D\uDC4E"),           // Thumbs Down
    CLAP("\uD83D\uDC4F"),                  // Clapping Hands
    HEART("\u2764\uFE0F"),                 // Red Heart
    FIRE("\uD83D\uDD25"),                  // Fire
    STAR("\u2B50"),                        // Star
    SMILE("\uD83D\uDE04"),                 // Smiling Face
    THINKING("\uD83E\uDD14"),              // Thinking Face
    SAD("\uD83D\uDE1E"),                   // Disappointed Face
    ANGRY("\uD83D\uDE21"),                 // Angry Face
    CRY("\uD83D\uDE22"),                   // Crying Face
    SHOCKED("\uD83D\uDE31"),               // Shocked Face
    SUN("\u2600\uFE0F"),                   // Sun
    MOON("\uD83C\uDF19"),                  // Crescent Moon
    CLOUD("\u2601\uFE0F"),                 // Cloud
    RAINBOW("\uD83C\uDF08"),               // Rainbow
    LIGHTNING("\u26A1"),                   // Lightning Bolt
    GLOBE("\uD83C\uDF0D"),                 // Globe (World)
    LOCK("\uD83D\uDD12"),                  // Locked
    UNLOCK("\uD83D\uDD13"),                // Unlocked
    PENCIL("\uD83D\uDCDD"),                // Memo (Pencil and Paper)
    CHECKMARK("\u2705"),                   // Checkmark
    CROSSMARK("\u274C"),                   // Crossmark
    STOP("\uD83D\uDED1"),                  // Stop Sign
    WARNING("\u26A0\uFE0F"),               // Warning Sign
    HOURGLASS("\u23F3"),                   // Hourglass
    CLOCK("\u23F0"),                       // Alarm Clock
    TRASH("\uD83D\uDDD1"),                 // Trash Can
    PAPERCLIP("\uD83D\uDCCE"),             // Paperclip
    BELL("\uD83D\uDD14"),                  // Bell (Notification)
    EYE("\uD83D\uDC41\uFE0F"),             // Eye
    SHIELD("\uD83D\uDEE1"),                // Shield
    GIFT("\uD83C\uDF81"),                  // Gift
    HANDSHAKE("\uD83E\uDD1D"),             // Handshake
    TROPHY("\uD83C\uDFC6"),                // Trophy
    MONEY_BAG("\uD83D\uDCB0"),             // Money Bag
    BALLOON("\uD83C\uDF88"),               // Balloon (Celebration)
    LIGHT_BULB("\uD83D\uDCA1"),            // Light Bulb (Idea)
    BOOK("\uD83D\uDCD6"),                  // Book
    HEADPHONES("\uD83C\uDFA7"),            // Headphones
    MICROPHONE("\uD83C\uDFA4"),            // Microphone
    CAMERA("\uD83D\uDCF7"),                // Camera
    VIDEO_CAMERA("\uD83D\uDCF9"),          // Video Camera
    FLOPPY_DISK("\uD83D\uDCBE"),           // Floppy Disk (Save)
    HOURGLASS_FLOW("\u23F3"),              // Hourglass Flowing Sand
    COMPUTER("\uD83D\uDCBB"),              // Laptop
    BAR_CHART("\uD83D\uDCCA"),             // Bar Chart (Analytics)
    CREDIT_CARD("\uD83D\uDCB3"),           // Credit Card (Payment)
    BANK("\uD83C\uDFE6"),                  // Bank
    CALENDAR("\uD83D\uDCC5"),              // Calendar (Event)
    HAND_WAVE("\uD83D\uDC4B"),             // Waving Hand
    PRAY("\uD83D\uDE4F"),                  // Folded Hands (Pray)
    MUSCLE("\uD83D\uDCAA"),                // Flexed Biceps
    PARTY_FACE("\uD83E\uDD73"),            // Party Face
    SMIRK_FACE("\uD83D\uDE0F"),            // Smirking Face
    COOL_FACE("\uD83D\uDE0E"),             // Smiling Face with Sunglasses
    ZANY_FACE("\uD83E\uDD2A"),             // Zany Face
    CONFUSED_FACE("\uD83D\uDE15"),         // Confused Face
    MONEY_FACE("\uD83E\uDD11"),            // Money-Mouth Face
    POOP("\uD83D\uDCA9"),                  // Pile of Poo
    UPSIDE_DOWN_FACE("\uD83D\uDE43"),      // Upside-Down Face
    FACE_PALM("\uD83E\uDD26"),             // Facepalm
    SHUSH("\uD83E\uDD2B"),                 // Shushing Face
    ZIPPER_MOUTH("\uD83E\uDD10"),          // Zipper-Mouth Face
    SLEEPING_FACE("\uD83D\uDE34"),         // Sleeping Face
    SNEEZE("\uD83E\uDD27"),                // Sneezing Face
    SICK("\uD83E\uDD12"),                  // Nauseated Face
    PARTY_BALLOON("\uD83C\uDF88"),         // Balloon
    CRYSTAL_BALL("\uD83D\uDD2E"),          // Crystal Ball
    WIZARD("\uD83E\uDDD9"),                // Wizard
    DRAGON("\uD83D\uDC09"),                // Dragon
    SPARKLES("\u2728"),                    // Sparkles
    CROWN("\uD83D\uDC51"),                 // Crown
    DIAMOND("\uD83D\uDC8E"),               // Diamond
    CAR("\uD83D\uDE97"),                   // Car
    BUS("\uD83D\uDE8C"),                   // Bus
    TRAIN("\uD83D\uDE82"),                 // Train
    PLANE("\u2708\uFE0F"),                 // Airplane
    SHIP("\uD83D\uDEA2"),                  // Ship
    BICYCLE("\uD83D\uDEB2"),               // Bicycle
    MOTORBIKE("\uD83D\uDEB5"),             // Motorbike
    FUEL_PUMP("\u26FD"),                   // Fuel Pump
    LIGHT_RAIL("\uD83D\uDE88"),            // Light Rail
    PARACHUTE("\uD83E\uDE82"),             // Parachute
    FOOTPRINTS("\uD83D\uDC63"),            // Footprints
    MOUNTAIN("\u26F0"),                    // Mountain
    FISHING_POLE("\uD83C\uDFA3"),          // Fishing Pole
    ANCHOR("\u2693"),                      // Anchor
    SAILBOAT("\u26F5"),                    // Sailboat
    WATERMELON("\uD83C\uDF49"),            // Watermelon
    PIZZA("\uD83C\uDF55"),                 // Pizza
    BURGER("\uD83C\uDF54"),                // Burger
    DONUT("\uD83C\uDF69"),                 // Doughnut
    PANCAKES("\uD83E\uDD5E"),              // Pancakes
    COFFEE("\u2615"),                      // Hot Beverage
    ICE_CREAM("\uD83C\uDF66"),             // Soft Ice Cream
    BEER("\uD83C\uDF7A"),                  // Beer Mug
    WINE("\uD83C\uDF77"),                  // Wine Glass
    TACO("\uD83C\uDF2E"),                  // Taco
    FRENCH_FRIES("\uD83C\uDF5F"),          // French Fries
    POPCORN("\uD83C\uDF7F"),               // Popcorn
    CUPCAKE("\uD83E\uDDC1"),               // Cupcake
    FOOTBALL("\u26BD"),                    // Soccer Ball
    BASKETBALL("\uD83C\uDFC0"),            // Basketball
    BASEBALL("\u26BE"),                    // Baseball
    TENNIS("\uD83C\uDFBE"),                // Tennis Ball
    SKI("\uD83C\uDFBF"),                   // Ski
    SNOWBOARD("\uD83C\uDFC2"),             // Snowboarder
    SURF("\uD83C\uDFC4"),                  // Surfer
    BOWLING("\uD83C\uDFB3"),               // Bowling
    MEDAL("\uD83C\uDFC5"),                 // Sports Medal
    FOOTBALL_HELMET("\uD83E\uDD4A"),       // American Football Helmet
    SPACE("\uD83C\uDF0C"),                 // Earth at Night
    ALIEN("\uD83D\uDC7D"),                 // Alien
    ROBOT_FACE("\uD83E\uDD16"),            // Robot Face
    SPACESHIP("\uD83D\uDE80"),             // Rocket (Spaceship)
    SATELLITE("\uD83D\uDEF0"),             // Satellite
    PLANET("\uD83C\uDF0F"),                // Globe Showing Asia-Australia
    COMET("\u2604\uFE0F"),                 // Comet
    SOLAR_SYSTEM("\uD83C\uDF1E"),          // Sun with Face
    ROSE("\uD83C\uDF39"),                  // Rose
    TULIP("\uD83C\uDF37"),                 // Tulip
    MAPLE_LEAF("\uD83C\uDF41"),            // Maple Leaf
    PALM_TREE("\uD83C\uDF34"),             // Palm Tree
    CACTUS("\uD83C\uDF35"),                // Cactus
    FLOWER("\uD83C\uDF3C"),                // Blossom
    DESKTOP("\uD83D\uDDA5"),               // Desktop Computer
    PRINTER("\uD83D\uDDA8"),               // Printer
    HARD_DRIVE("\uD83D\uDCBA"),            // Hard Drive
    SATELLITE_DISH("\uD83D\uDCE1"),        // Satellite Dish
    SERVER("\uD83D\uDCBD"),                // Computer Disk/Server
    ELECTRIC_PLUG("\uD83D\uDD0C"),         // Electric Plug
    BATTERY("\uD83D\uDD0B"),               // Battery
    MAGNET("\uD83D\uDD2F"),                // Magnet
    GEAR("\u2699"),                        // Gear (Settings)
    CHIP("\uD83D\uDD0C"),                  // Microchip
    TOOLBOX("\uD83D\uDEE0"),               // Toolbox (Repair)
    SCREWDRIVER("\uD83D\uDD29"),           // Screwdriver
    WRENCH("\uD83D\uDD27"),                // Wrench
    HAMMER("\uD83D\uDD28"),                // Hammer
    PICK("\u26CF"),                        // Pickaxe
    MEASURE_TAPE("\uD83D\uDCCA"),          // Measure Tape
    CIRCUIT("\uD83D\uDD0C"),               // Electrical Circuit
    ANTENNA("\uD83D\uDDEF"),               // Antenna Bars
    SIGNAL_BARS("\uD83D\uDCF6"),           // Signal Strength
    WIFI("\uD83D\uDCF6"),                  // WiFi
    RADIO("\uD83D\uDCFB"),                 // Radio
    MOBILE_PHONE("\uD83D\uDCF1"),          // Mobile Phone
    CLOUD_UPLOAD("\uD83D\uDCE4"),          // Cloud Upload
    CLOUD_DOWNLOAD("\uD83D\uDCE5"),        // Cloud Download
    FILE("\uD83D\uDCC4"),                  // File
    FILE_FOLDER("\uD83D\uDCC1"),           // File Folder
    FOLDER("\uD83D\uDCC2"),                // Open Folder
    CLIPBOARD("\uD83D\uDCCB"),             // Clipboard
    LOCK_OPEN("\uD83D\uDD13"),             // Open Lock
    BUG("\uD83D\uDC1B"),                   // Bug (Software Bug)
    PROGRAMMER("\uD83D\uDC68\u200D\uD83D\uDCBB"),  // Man with Laptop (Developer)
    FEMALE_PROGRAMMER("\uD83D\uDC69\u200D\uD83D\uDCBB"),  // Woman with Laptop (Female Developer)
    FIREWALL("\uD83D\uDD25"),              // Firewall
    DATABASE("\uD83D\uDCDB"),              // Database
    CONSOLE("\uD83D\uDDA5"),               // Console
    CPU("\uD83D\uDDA6"),                   // CPU (Processor)
    ELECTRIC("\uD83D\uDD0B"),              // Electric Power
    PROGRESS_BAR("\uD83D\uDCAF"),          // Progress Bar
    STOPWATCH("\u23F1"),                   // Stopwatch (Performance)
    THERMOMETER("\uD83C\uDF21"),           // Thermometer (Temperature)
    KEYBOARD("\u2328\uFE0F"),              // Keyboard
    MOUSE("\uD83D\uDCBB"),                 // Mouse
    CD("\uD83D\uDCBF"),                    // CD (Optical Disk)
    TAPE("\uD83D\uDCFC"),                  // Tape Reel
    SCROLL("\uD83D\uDCDC"),                // Scroll (Log)
    ROBOT("\uD83E\uDD16"),                 // Robot (Automation)
    MIC("\uD83C\uDF99"),                   // Microphone (Recording)
    USB("\uD83D\uDCBB"),                   // USB Plug
    ROUTER("\uD83D\uDD04"),                // Router (Network)
    ETHERNET_CABLE("\uD83D\uDCF6"),        // Ethernet Cable
    SIM_CARD("\uD83D\uDCF2"),              // SIM Card (Mobile Network)
    BARCODE("\uD83D\uDCCF"),               // Barcode (QR Code)
    SOLDERING_IRON("\uD83E\uDDC8"),        // Soldering Iron
    FIBER_CABLE("\uD83C\uDF1D"),           // Fiber Optic Cable
    CPU_CHIP("\uD83D\uDD0C"),              // CPU Chip (Processing)
    ANTENNA_BARS("\uD83D\uDEF6"),          // Antenna Bars
    TOOL_BELT("\uD83E\uDDE3"),             // Tool Belt (Tools)
    WIRING("\uD83E\uDDEF"),                // Wiring (Circuits)
    SATELLITE_ANTENNA("\uD83D\uDCFB"),     // Satellite Antenna
    SERVER_RACK("\uD83D\uDCBB"),           // Server Rack
    ETHERNET("\uD83D\uDCF6"),              // Ethernet Plug
    TOOL("\uD83E\uDD29"),                  // Toolbox
    DEBUG("\uD83D\uDC1E"),                 // Bug for Debugging
    PLUG("\uD83D\uDD0C"),                  // Power Plug (Connector)
    WRENCH_SCREWDRIVER("\uD83D\uDEE0")     // Wrench and Screwdriver
    ;

    private final String icon;

    TelegramIconMode(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
// @formatter:on
