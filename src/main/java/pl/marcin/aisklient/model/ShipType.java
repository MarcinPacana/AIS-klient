package pl.marcin.aisklient.model;

public enum ShipType {

    DEFAULT(0, "Not available (default)"),
    RESERVED_FOR_FUTURE(1, "Reserved for future use"),  // reserved from 1 to 19 typeCode

    WING1(20, "Wing in ground (WIG), all ships of this type"),
    WING2(21, "Wing in ground (WIG), Hazardous category A"),
    WING3(22, "Wing in ground (WIG), Hazardous category B"),
    WING4(23, "Wing in ground (WIG), Hazardous category C"),
    WING5(24, "Wing in ground (WIG), Hazardous category D"),
    WING6(25, "Wing in ground (WIG), Reserved for future use"),
    WING7(26, "Wing in ground (WIG), Reserved for future use"),
    WING8(27, "Wing in ground (WIG), Reserved for future use"),
    WING9(28, "Wing in ground (WIG), Reserved for future use"),
    WING10(29, "Wing in ground (WIG), Reserved for future use"),

    FISHING(30, "FISHING"),
    TOWING1(31, "TOWING"),
    TOWING2(32, "Towing: length exceeds 200m or breadth exceeds 25m"),
    DREDGING(33, " Dredging or underwater ops"),
    DIVING(34, "Diving ops"),
    MILITARY(35, "Military ops"),
    SAILING(36, "Sailing"),
    PLEASURE_CRAFT(37, "Pleasure Craft"),
    RESERVED1(38, "Reserved"),
    RESERVED2(39, "Reserved"),

    HIGH_SPEED_CRAFT1(40, "High speed craft (HSC), all ships of this type"),
    HIGH_SPEED_CRAFT2(41, "High speed craft (HSC), Hazardous category A"),
    HIGH_SPEED_CRAFT3(42, "High speed craft (HSC), Hazardous category B"),
    HIGH_SPEED_CRAFT4(43, "High speed craft (HSC), Hazardous category C"),
    HIGH_SPEED_CRAFT5(44, "High speed craft (HSC), Hazardous category D"),
    HIGH_SPEED_CRAFT6(45, "High speed craft (HSC), Reserved for future use"),
    HIGH_SPEED_CRAFT7(46, "High speed craft (HSC), Reserved for future use"),
    HIGH_SPEED_CRAFT8(47, "High speed craft (HSC), Reserved for future use"),
    HIGH_SPEED_CRAFT9(48, "High speed craft (HSC), Reserved for future use"),
    HIGH_SPEED_CRAFT10(49, "High speed craft (HSC), No additional information"),

    PILOT_VESSEL(50, "Pilot Vessel"),
    SEARCH_RESCUE_VESSEL(51, "Search and Rescue vessel"),
    TUG(52, "Tug"),
    PORT_TENDER(53, "Port Tender"),
    ANTI_POLLUTION_EQUIPMENT(54, "Anti-pollution equipment"),
    LAW_ENFORCEMENT(55, "Law Enforcement"),
    SPARE_LOCAL_VESSEL1(56, "Spare - Local Vessel"),
    SPARE_LOCAL_VESSEL2(57, "Spare - Local Vessel"),
    MEDIA_TRANSPORT(58, "Medical Transport"),
    NOCOMBATANT(59, "Noncombatant ship according to RR Resolution No. 18"),

    PASSANGER1(60, "Passenger, all ships of this type"),
    PASSANGER2(61, "Passenger, Hazardous category A"),
    PASSANGER3(62, "Passenger, Hazardous category B"),
    PASSANGER4(63, "Passenger, Hazardous category C"),
    PASSANGER5(64, "Passenger, Hazardous category D"),
    PASSANGER6(65, "Passenger, Reserved for future use"),
    PASSANGER7(66, "Passenger, Reserved for future use"),
    PASSANGER8(67, "Passenger, Reserved for future use"),
    PASSANGER9(68, "Passenger, Reserved for future use"),
    PASSANGER10(69, "Passenger, No additional information"),

    CARGO1(70, "Cargo, all ships of this type"),
    CARGO2(71, "Cargo, Hazardous category A"),
    CARGO3(72, "Cargo, Hazardous category B"),
    CARGO4(73, "Cargo, Hazardous category C"),
    CARGO5(74, "Cargo, Hazardous category D"),
    CARGO6(75, "Cargo, Reserved for future use"),
    CARGO7(76, "Cargo, Reserved for future use"),
    CARGO8(77, "Cargo, Reserved for future use"),
    CARGO9(78, "Cargo, Reserved for future use"),
    CARGO10(79, "Cargo, No additional information"),

    TANKER1(80, "Tanker, all ships of this type"),
    TANKER2(81, "Tanker, Hazardous category A"),
    TANKER3(82, "Tanker, Hazardous category B"),
    TANKER4(83, "Tanker, Hazardous category C"),
    TANKER5(84, "Tanker, Hazardous category D"),
    TANKER6(85, "Tanker, Reserved for future use"),
    TANKER7(86, "Tanker, Reserved for future use"),
    TANKER8(87, "Tanker, Reserved for future use"),
    TANKER9(88, "Tanker, Reserved for future use"),
    TANKER10(89, "Tanker, No additional information"),

    OTHER1(90, "Other Type, all ships of this type"),
    OTHER2(91, "Other Type, Hazardous category A"),
    OTHER3(92, "Other Type, Hazardous category B"),
    OTHER4(93, "Other Type, Hazardous category C"),
    OTHER5(94, "Other Type, Hazardous category D"),
    OTHER6(95, "Other Type, Reserved for future use"),
    OTHER7(96, "Other Type, Reserved for future use"),
    OTHER8(97, "Other Type, Reserved for future use"),
    OTHER9(98, "Other Type, Reserved for future use"),
    OTHER10(99, "Other Type, no additional information");


    private final int typeCode;
    private final String typeName;


    ShipType(int typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public static ShipType getByTypeCode(int typeCode) {
        for (ShipType ship : ShipType.values()) {
            if (ship.getTypeCode() == typeCode) {
                return ship;
            }
        }
        return null;
    }
}
