/**
 * 
 */
package org.openntf.redomino.utils;

//import java.util.TimeZone;

/**
 * Lotus time zones enum (v.9.0.1 FP5).
 * 
 * @author Vladimir Kornienko
 * 
 */
public enum TimeZones {
	// reserve index 0 for potential system use
	// FIXME this is way too fat. dump into a property file, probably? 
	// also i don't need most of these zones anyway, since multiple IANA zones collapse into 1 Lotus zone. prune?
	AFRICA_ABIDJAN(1, TimeZones.lotusZones[34][0], "Africa/Abidjan", TimeZones.lotusZones[34][1]), 
	AFRICA_ACCRA(2, TimeZones.lotusZones[34][0], "Africa/Accra", TimeZones.lotusZones[34][1]), 
	AFRICA_ADDIS_ABABA(3, TimeZones.lotusZones[58][0], "Africa/Addis_Ababa", TimeZones.lotusZones[58][1]), 
	AFRICA_ALGIERS(4, TimeZones.lotusZones[41][0], "Africa/Algiers", TimeZones.lotusZones[41][1]), 
	AFRICA_ASMARA(5, TimeZones.lotusZones[58][0], "Africa/Asmara", TimeZones.lotusZones[58][1]), 
	AFRICA_ASMERA(6, TimeZones.lotusZones[58][0], "Africa/Asmera", TimeZones.lotusZones[58][1]), 
	AFRICA_BAMAKO(7, TimeZones.lotusZones[34][0], "Africa/Bamako", TimeZones.lotusZones[34][1]), 
	AFRICA_BANGUI(8, TimeZones.lotusZones[41][0], "Africa/Bangui", TimeZones.lotusZones[41][0]), 
	AFRICA_BANJUL(9, TimeZones.lotusZones[34][0], "Africa/Banjul", TimeZones.lotusZones[34][1]), 
	AFRICA_BISSAU(10, TimeZones.lotusZones[34][0], "Africa/Bissau", TimeZones.lotusZones[34][1]), 
	AFRICA_BLANTYRE(11, TimeZones.lotusZones[52][0], "Africa/Blantyre", TimeZones.lotusZones[52][1]), 
	AFRICA_BRAZZAVILLE(12, TimeZones.lotusZones[41][0], "Africa/Brazzaville", TimeZones.lotusZones[41][1]), 
	AFRICA_BUJUMBURA(13, TimeZones.lotusZones[52][0], "Africa/Bujumbura", TimeZones.lotusZones[52][1]), 
	AFRICA_CAIRO(14, TimeZones.lotusZones[44][0], "Africa/Cairo",  TimeZones.lotusZones[44][1]), 
	AFRICA_CASABLANCA(15, TimeZones.lotusZones[35][0], "Africa/Casablanca",  TimeZones.lotusZones[35][1]), 
	AFRICA_CEUTA(16, TimeZones.lotusZones[39][0], "Africa/Ceuta",  TimeZones.lotusZones[39][1]), 
	AFRICA_CONAKRY(17, TimeZones.lotusZones[34][0], "Africa/Conakry", TimeZones.lotusZones[34][1]), 
	AFRICA_DAKAR(18, TimeZones.lotusZones[34][0], "Africa/Dakar", TimeZones.lotusZones[34][1]), 
	AFRICA_DAR_ES_SALAAM(19, TimeZones.lotusZones[58][0], "Africa/Dar_es_Salaam", TimeZones.lotusZones[58][1]), 
	AFRICA_DJIBOUTI(20, TimeZones.lotusZones[58][0], "Africa/Djibouti", TimeZones.lotusZones[58][1]), 
	AFRICA_DOUALA(21, TimeZones.lotusZones[41][0], "Africa/Douala", TimeZones.lotusZones[41][1]), 
	AFRICA_EL_AAIUN(22, TimeZones.lotusZones[35][0], "Africa/El_Aaiun", TimeZones.lotusZones[35][1]), 
	AFRICA_FREETOWN(23, TimeZones.lotusZones[34][0], "Africa/Freetown", TimeZones.lotusZones[34][1]), 
	AFRICA_GABORONE(24, TimeZones.lotusZones[52][0], "Africa/Gaborone", TimeZones.lotusZones[52][1]), 
	AFRICA_HARARE(25, TimeZones.lotusZones[52][0], "Africa/Harare", TimeZones.lotusZones[52][1]), 
	AFRICA_JOHANNESBURG(26, TimeZones.lotusZones[52][0], "Africa/Johannesburg", TimeZones.lotusZones[52][1]), 
	AFRICA_JUBA(27, TimeZones.lotusZones[58][0], "Africa/Juba", TimeZones.lotusZones[58][1]), 
	AFRICA_KAMPALA(29, TimeZones.lotusZones[58][0], "Africa/Kampala", TimeZones.lotusZones[58][1]), 
	AFRICA_KHARTOUM(30, TimeZones.lotusZones[58][0], "Africa/Khartoum", TimeZones.lotusZones[58][1]), 
	AFRICA_KIGALI(31, TimeZones.lotusZones[52][0], "Africa/Kigali", TimeZones.lotusZones[52][1]), 
	AFRICA_KINSHASA(32, TimeZones.lotusZones[41][0], "Africa/Kinshasa", TimeZones.lotusZones[41][1]), 
	AFRICA_LAGOS(33, TimeZones.lotusZones[41][0], "Africa/Lagos", TimeZones.lotusZones[41][1]), 
	AFRICA_LIBREVILLE(34, TimeZones.lotusZones[41][0], "Africa/Libreville", TimeZones.lotusZones[41][1]), 
	AFRICA_LOME(35, TimeZones.lotusZones[41][0], "Africa/Lome", TimeZones.lotusZones[41][1]),
	AFRICA_LUANDA(36, TimeZones.lotusZones[41][0], "Africa/Luanda", TimeZones.lotusZones[41][1]),
	AFRICA_LUBUMBASHI(37, TimeZones.lotusZones[52][0], "Africa/Lubumbashi", TimeZones.lotusZones[52][1]),
	AFRICA_LUSAKA(38, TimeZones.lotusZones[52][0], "Africa/Lusaka", TimeZones.lotusZones[52][1]),
	AFRICA_MALABO(39, TimeZones.lotusZones[41][0], "Africa/Malabo", TimeZones.lotusZones[41][1]),
	AFRICA_MAPUTO(40, TimeZones.lotusZones[52][0], "Africa/Maputo", TimeZones.lotusZones[52][1]),
	AFRICA_MASERU(41, TimeZones.lotusZones[52][0], "Africa/Maseru", TimeZones.lotusZones[52][1]),
	AFRICA_MBABANE(42, TimeZones.lotusZones[52][0], "Africa/Mbabane", TimeZones.lotusZones[52][1]),
	AFRICA_MOGADISHU(43, TimeZones.lotusZones[58][0], "Africa/Mogadishu", TimeZones.lotusZones[58][1]),
	AFRICA_MONROVIA(44, TimeZones.lotusZones[34][0], "Africa/Monrovia", TimeZones.lotusZones[34][1]),
	AFRICA_NAIROBI(45, TimeZones.lotusZones[58][0], "Africa/Nairobi", TimeZones.lotusZones[58][1]),
	AFRICA_NDJAMENA(46, TimeZones.lotusZones[41][0], "Africa/Ndjamena", TimeZones.lotusZones[41][1]),
	AFRICA_NIAMEY(47, TimeZones.lotusZones[41][0], "Africa/Niamey", TimeZones.lotusZones[41][1]),
	AFRICA_NOUAKCHOTT(48, TimeZones.lotusZones[36][0], "Africa/Nouakchott", TimeZones.lotusZones[36][1]),
	AFRICA_OUAGADOUGOU(49, TimeZones.lotusZones[36][0], "Africa/Ouagadougou", TimeZones.lotusZones[36][1]),
	AFRICA_PORTO_NOVO(50, TimeZones.lotusZones[41][0], "Africa/Porto-Novo", TimeZones.lotusZones[41][1]),
	AFRICA_SAO_TOME(51, TimeZones.lotusZones[36][0], "Africa/Sao_Tome", TimeZones.lotusZones[36][1]),
	AFRICA_TIMBUKTU(52, TimeZones.lotusZones[36][0], "Africa/Timbuktu", TimeZones.lotusZones[36][1]),
	AFRICA_TRIPOLI(53, TimeZones.lotusZones[50][0], "Africa/Tripoli", TimeZones.lotusZones[50][1]),
	AFRICA_TUNIS(54, TimeZones.lotusZones[41][0], "Africa/Tunis", TimeZones.lotusZones[41][1]),
	AFRICA_WINDHOEK(55, TimeZones.lotusZones[39][0], "Africa/Windhoek", TimeZones.lotusZones[39][1]),
	AMERICA_ADAK(56, TimeZones.lotusZones[2][0], "America/Adak", TimeZones.lotusZones[2][1]), // no Lotus zone equivalent
	AMERICA_ANCHORAGE(57, TimeZones.lotusZones[3][0], "America/Anchorage", TimeZones.lotusZones[3][1]),
	AMERICA_ANGUILLA(58, TimeZones.lotusZones[21][0], "America/Anguilla", TimeZones.lotusZones[21][1]),
	AMERICA_ANTIGUA(59, TimeZones.lotusZones[21][0], "America/Antigua", TimeZones.lotusZones[21][1]),
	AMERICA_ARAGUAINA(60, TimeZones.lotusZones[28][0], "America/Araguaina", TimeZones.lotusZones[28][1]),
	AMERICA_ARGENTINA_BEUNOS_AIRES(61, TimeZones.lotusZones[23][0], "America/Argentina/Buenos_Aires", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_CATAMARCA(62, TimeZones.lotusZones[23][0], "America/Argentina/Catamarca", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_COMODRIVADAVIA(63, TimeZones.lotusZones[23][0], "America/Argentina/ComodRivadavia", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_CORDOBA(64, TimeZones.lotusZones[23][0], "America/Argentina/Cordoba", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_JUJUY(65, TimeZones.lotusZones[23][0], "America/Argentina/Jujuy", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_LA_RIOJA(66, TimeZones.lotusZones[23][0], "America/Argentina/La_Rioja", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_MENDOZA(67, TimeZones.lotusZones[23][0], "America/Argentina/Mendoza", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_RIO_GALLEGOS(68, TimeZones.lotusZones[23][0], "America/Argentina/Rio_Gallegos", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_SALTA(69, TimeZones.lotusZones[23][0], "America/Argentina/Salta", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_SAN_JUAN(70, TimeZones.lotusZones[23][0], "America/Argentina/San_Juan", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_SAN_LUIS(71, TimeZones.lotusZones[23][0], "America/Argentina/San_Luis", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_TUCUMAN(72, TimeZones.lotusZones[23][0], "America/Argentina/Tucuman", TimeZones.lotusZones[23][1]),
	AMERICA_ARGENTINA_USHUAIA(73, TimeZones.lotusZones[23][0], "America/Argentina/Ushuaia", TimeZones.lotusZones[23][1]),
	AMERICA_ARUBA(74, TimeZones.lotusZones[21][0], "America/Aruba", TimeZones.lotusZones[21][1]),
	AMERICA_ASUNCION(75, TimeZones.lotusZones[20][0], "America/Asuncion", TimeZones.lotusZones[20][1]),
	AMERICA_ATIKOKAN(76, TimeZones.lotusZones[14][0], "America/Atikokan", TimeZones.lotusZones[14][1]),
	AMERICA_ATKA(77, TimeZones.lotusZones[1][0], "America/Atka", TimeZones.lotusZones[1][1]), // no Lotus zone equivalent
	AMERICA_BAHIA(78, TimeZones.lotusZones[28][0], "America/Bahia", TimeZones.lotusZones[28][1]),
	AMERICA_BAHIA_BANDERAS(79, TimeZones.lotusZones[12][0], "America/Bahia_Banderas", TimeZones.lotusZones[12][1]),
	AMERICA_BARBADOS(80, TimeZones.lotusZones[21][0], "America/Barbados", TimeZones.lotusZones[21][1]),
	AMERICA_BELEM(81, TimeZones.lotusZones[28][0], "America/Belem", TimeZones.lotusZones[28][1]),
	AMERICA_BELIZE(82, TimeZones.lotusZones[10][0], "America/Belize", TimeZones.lotusZones[10][1]),
	AMERICA_BLANC_SABLON(83, TimeZones.lotusZones[21][0], "America/Blanc-Sablon", TimeZones.lotusZones[21][1]),
	AMERICA_BOA_VISTA(84, TimeZones.lotusZones[21][0], "America/Boa_Vista", TimeZones.lotusZones[21][1]),
	AMERICA_BOGOTA(85, TimeZones.lotusZones[14][0], "America/Bogota", TimeZones.lotusZones[14][1]),
	AMERICA_BOISE(86, TimeZones.lotusZones[6][0], "America/Boise", TimeZones.lotusZones[6][1]),
	AMERICA_BUENOS_AIRES(87, TimeZones.lotusZones[23][0], "America/Buenos_Aires", TimeZones.lotusZones[23][1]),
	AMERICA_CAMBRIDGE_BAY(88, TimeZones.lotusZones[6][0], "America/Cambridge_Bay", TimeZones.lotusZones[6][1]),
	AMERICA_CAMPO_GRANDE(89, TimeZones.lotusZones[18][0], "America/Campo_Grande", TimeZones.lotusZones[18][1]),
	AMERICA_CANCUN(90, TimeZones.lotusZones[14][0], "America/Cancun", TimeZones.lotusZones[14][1]),
	AMERICA_CARACAS(91, TimeZones.lotusZones[21][0], "America/Caracas", TimeZones.lotusZones[21][1]),
	AMERICA_CATAMARCA(92, TimeZones.lotusZones[23][0], "America/Catamarca", TimeZones.lotusZones[23][1]),
	AMERICA_CAYENNE(93, TimeZones.lotusZones[28][0], "America/Cayenne", TimeZones.lotusZones[28][1]),
	AMERICA_CAYMAN(94, TimeZones.lotusZones[14][0], "America/Cayman", TimeZones.lotusZones[14][1]),
	AMERICA_CHICAGO(95, TimeZones.lotusZones[11][0], "America/Chicago", TimeZones.lotusZones[11][1]),
	AMERICA_CHIHUAHUA(96, TimeZones.lotusZones[7][0], "America/Chihuahua", TimeZones.lotusZones[7][1]),
	AMERICA_CORAL_HARBOUR(97, TimeZones.lotusZones[14][0], "America/Coral_Harbour", TimeZones.lotusZones[14][1]),
	AMERICA_CORDOBA(98, TimeZones.lotusZones[23][0], "America/Cordoba", TimeZones.lotusZones[23][1]),
	AMERICA_COSTA_RICA(99, TimeZones.lotusZones[10][0], "America/Costa_Rica", TimeZones.lotusZones[10][1]),
	AMERICA_CRESTON(100, TimeZones.lotusZones[8][0], "America/Creston", TimeZones.lotusZones[8][1]),
	AMERICA_CUIABA(101, TimeZones.lotusZones[18][0], "America/Cuiaba", TimeZones.lotusZones[18][1]),
	AMERICA_CURACAO(102, TimeZones.lotusZones[21][0], "America/Curacao", TimeZones.lotusZones[21][1]),
	AMERICA_DANMARKSHAVN(103, TimeZones.lotusZones[34][0], "America/Danmarkshavn", TimeZones.lotusZones[34][1]),
	AMERICA_DAWSON(104, TimeZones.lotusZones[4][0], "America/Dawson", TimeZones.lotusZones[4][1]),
	AMERICA_DAWSON_CREEK(105, TimeZones.lotusZones[8][0], "America/Dawson_Creek", TimeZones.lotusZones[8][1]),
	AMERICA_DENVER(106, TimeZones.lotusZones[6][0], "America/Denver", TimeZones.lotusZones[6][1]),
	AMERICA_DETROIT(107, TimeZones.lotusZones[13][0], "America/Detroit", TimeZones.lotusZones[13][1]),
	AMERICA_DOMINICA(108, TimeZones.lotusZones[21][0], "America/Dominica", TimeZones.lotusZones[21][1]),
	AMERICA_EDMONTON(109, TimeZones.lotusZones[6][0], "America/Edmonton", TimeZones.lotusZones[6][1]),
	AMERICA_EIRUNEPE(110, TimeZones.lotusZones[14][0], "America/Eirunepe", TimeZones.lotusZones[14][1]),
	AMERICA_EL_SALVADOR(111, TimeZones.lotusZones[10][0], "America/El_Salvador", TimeZones.lotusZones[10][1]),
	AMERICA_ENSENADA(112, TimeZones.lotusZones[5][0], "America/Ensenada", TimeZones.lotusZones[5][1]),
	AMERICA_FORT_NELSON(113, TimeZones.lotusZones[7][0], "America/Fort_Nelson", TimeZones.lotusZones[7][1]),
	AMERICA_FORT_WAYNE(114, TimeZones.lotusZones[15][0], "America/Fort_Wayne", TimeZones.lotusZones[15][1]),
	AMERICA_FORTALEZA(115, TimeZones.lotusZones[28][0], "America/Fortaleza", TimeZones.lotusZones[28][1]),
	AMERICA_GLACE_BAY(116, TimeZones.lotusZones[17][0], "America/Glace_Bay", TimeZones.lotusZones[17][1]),
	AMERICA_GODTHAB(117, TimeZones.lotusZones[26][0], "America/Godthab", TimeZones.lotusZones[26][1]),
	AMERICA_GOOSE_BAY(118, TimeZones.lotusZones[17][0], "America/Goose_Bay", TimeZones.lotusZones[17][1]),
	AMERICA_GRAND_TURK(119, TimeZones.lotusZones[21][0], "America/Grand_Turk", TimeZones.lotusZones[21][1]),
	AMERICA_GRENADA(120, TimeZones.lotusZones[21][0], "America/Grenada", TimeZones.lotusZones[21][1]),
	AMERICA_GUADELOUPE(121, TimeZones.lotusZones[21][0], "America/Guadeloupe", TimeZones.lotusZones[21][1]),
	AMERICA_GUATEMALA(122, TimeZones.lotusZones[10][0], "America/Guatemala", TimeZones.lotusZones[10][1]),
	AMERICA_GUAYAQUIL(123, TimeZones.lotusZones[14][0], "America/Guayaquil", TimeZones.lotusZones[14][1]),
	AMERICA_GUYANA(124, TimeZones.lotusZones[21][0], "America/Guyana", TimeZones.lotusZones[21][1]),
	AMERICA_HALIFAX(125, TimeZones.lotusZones[17][0], "America/Halifax", TimeZones.lotusZones[17][1]),
	AMERICA_HAVANA(126, TimeZones.lotusZones[13][0], "America/Havana", TimeZones.lotusZones[13][1]),
	AMERICA_HERMOSILLO(127, TimeZones.lotusZones[8][0], "America/Hermosillo", TimeZones.lotusZones[8][1]),
	AMERICA_INDIANA_INDIANAPOLIS(128, TimeZones.lotusZones[15][0], "America/Indiana/Indianapolis", TimeZones.lotusZones[15][1]),
	AMERICA_INDIANA_KNOX(129, TimeZones.lotusZones[11][0], "America/Indiana/Knox", TimeZones.lotusZones[11][1]),
	AMERICA_INDIANA_MARENGO(130, TimeZones.lotusZones[15][0], "America/Indiana/Marengo", TimeZones.lotusZones[15][1]),
	AMERICA_INDIANA_PETERSBURG(131, TimeZones.lotusZones[15][0], "America/Indiana/Petersburg", TimeZones.lotusZones[15][1]),
	AMERICA_INDIANA_TELL_CITY(132, TimeZones.lotusZones[11][0], "America/Indiana/Tell_City", TimeZones.lotusZones[11][1]),
	AMERICA_INDIANA_VEVAY(133, TimeZones.lotusZones[15][0], "America/Indiana/Vevay", TimeZones.lotusZones[15][1]),
	AMERICA_INDIANA_VINCENNES(134, TimeZones.lotusZones[15][0], "America/Indiana/Vincennes", TimeZones.lotusZones[15][1]),
	AMERICA_INDIANA_WINAMAC(135, TimeZones.lotusZones[15][0], "America/Indiana/Winamac", TimeZones.lotusZones[15][1]),
	AMERICA_INDIANAPOLIS(136, TimeZones.lotusZones[15][0], "America/Indianapolis", TimeZones.lotusZones[15][1]),
	AMERICA_INUVIK(137, TimeZones.lotusZones[6][0], "America/Inuvik", TimeZones.lotusZones[6][1]),
	AMERICA_IQALIUT(138, TimeZones.lotusZones[13][0], "America/Iqaliut", TimeZones.lotusZones[13][1]),
	AMERICA_JAMAICA(139, TimeZones.lotusZones[14][0], "America/Jamaica", TimeZones.lotusZones[14][1]),
	AMERICA_JUJUY(140, TimeZones.lotusZones[23][0], "America/Jujuy", TimeZones.lotusZones[23][1]),
	AMERICA_JUNEAU(141, TimeZones.lotusZones[3][0], "America/Juneau", TimeZones.lotusZones[3][1]),
	AMERICA_KENTUCKY_LOUISVILLE(142, TimeZones.lotusZones[13][0], "America/Kentucky/Louisville", TimeZones.lotusZones[13][1]),
	AMERICA_KENTUCKY_MONTICELLO(143, TimeZones.lotusZones[13][0], "America/Kentucky/Monticello", TimeZones.lotusZones[13][1]),
	AMERICA_KNOX_IN(144, TimeZones.lotusZones[11][0], "America/Knox_IN", TimeZones.lotusZones[11][1]),
	AMERICA_KRALENDIJK(145, TimeZones.lotusZones[21][0], "America/Kralendijk", TimeZones.lotusZones[21][1]),
	AMERICA_LA_PAZ(146, TimeZones.lotusZones[21][0], "America/La_Paz", TimeZones.lotusZones[21][1]),
	AMERICA_LIMA(147, TimeZones.lotusZones[14][0], "America/Lima", TimeZones.lotusZones[14][1]),
	AMERICA_LOS_ANGELES(148, TimeZones.lotusZones[4][0], "America/Los_Angeles", TimeZones.lotusZones[4][1]),
	AMERICA_LOUISVILLE(149, TimeZones.lotusZones[13][0], "America/Louisville", TimeZones.lotusZones[13][1]),
	AMERICA_LOWER_PRINCES(150, TimeZones.lotusZones[21][0], "America/Lower_Princes", TimeZones.lotusZones[21][1]),
	AMERICA_MACEIO(151, TimeZones.lotusZones[28][0], "America/Maceio", TimeZones.lotusZones[28][1]),
	AMERICA_MANAGUA(152, TimeZones.lotusZones[10][0], "America/Managua", TimeZones.lotusZones[10][1]),
	AMERICA_MANAUS(153, TimeZones.lotusZones[21][0], "America/Manaus", TimeZones.lotusZones[21][1]),
	AMERICA_MARIGOT(154, TimeZones.lotusZones[21][0], "America/Marigot", TimeZones.lotusZones[21][1]),
	AMERICA_MARTINIQUE(155, TimeZones.lotusZones[21][0], "America/Martinique", TimeZones.lotusZones[21][1]),
	AMERICA_MATAMOROS(156, TimeZones.lotusZones[12][0], "America/Matamoros", TimeZones.lotusZones[12][1]),
	AMERICA_MAZATLAN(157, TimeZones.lotusZones[7][0], "America/Mazatlan", TimeZones.lotusZones[7][1]),
	AMERICA_MENDOZA(158, TimeZones.lotusZones[23][0], "America/Mendoza", TimeZones.lotusZones[23][1]),
	AMERICA_MENOMINEE(159, TimeZones.lotusZones[11][0], "America/Menominee", TimeZones.lotusZones[11][1]),
	AMERICA_MERIDA(160, TimeZones.lotusZones[12][0], "America/Merida", TimeZones.lotusZones[12][1]),
	AMERICA_METLAKATLA(161, TimeZones.lotusZones[3][0], "America/Metlakatla", TimeZones.lotusZones[3][1]),
	AMERICA_MEXICO_CITY(162, TimeZones.lotusZones[12][0], "America/Mexico_City", TimeZones.lotusZones[12][1]),
	AMERICA_MIQUELEON(163, TimeZones.lotusZones[28][0], "America/Miqueleon", TimeZones.lotusZones[28][1]),
	AMERICA_MONCTON(164, TimeZones.lotusZones[17][0], "America/Moncton", TimeZones.lotusZones[17][1]),
	AMERICA_MONTERREY(165, TimeZones.lotusZones[12][0], "America/Monterrey", TimeZones.lotusZones[12][1]),
	AMERICA_MONTEVIDEO(166, TimeZones.lotusZones[27][0], "America/Montevideo", TimeZones.lotusZones[27][1]),
	AMERICA_MONTREAL(167, TimeZones.lotusZones[13][0], "America/Montreal", TimeZones.lotusZones[13][1]),
	AMERICA_MONTSERRAT(168, TimeZones.lotusZones[21][0], "America/Montserrat", TimeZones.lotusZones[21][1]),
	AMERICA_NASSAU(169, TimeZones.lotusZones[13][0], "America/Nassau", TimeZones.lotusZones[13][1]),
	AMERICA_NEW_YORK(170, TimeZones.lotusZones[13][0], "America/New_York", TimeZones.lotusZones[13][1]),
	AMERICA_NIPIGON(171, TimeZones.lotusZones[13][0], "America/Nipigon", TimeZones.lotusZones[13][1]),
	AMERICA_NOME(172, TimeZones.lotusZones[3][0], "America/Nome", TimeZones.lotusZones[3][1]),
	AMERICA_NORONHA(173, TimeZones.lotusZones[30][0], "America/Noronha", TimeZones.lotusZones[30][1]),
	AMERICA_NORTH_DAKOTA_BEULAH(174, TimeZones.lotusZones[11][0], "America/North_Dakota/Beulah", TimeZones.lotusZones[11][1]),
	AMERICA_NORTH_DAKOTA_CENTER(175, TimeZones.lotusZones[11][0], "America/North_Dakota/Center", TimeZones.lotusZones[11][1]),
	AMERICA_NORTH_DAKOTA_NEW_SALEM(176, TimeZones.lotusZones[11][0], "America/North_Dakota/New_Salem", TimeZones.lotusZones[11][1]),
	AMERICA_OJINAGA(177, TimeZones.lotusZones[7][0], "America/Ojinaga", TimeZones.lotusZones[7][1]),
	AMERICA_PANAMA(178, TimeZones.lotusZones[14][0], "America/Panama", TimeZones.lotusZones[14][1]),
	AMERICA_PANGNIRTUNG(179, TimeZones.lotusZones[13][0], "America/Pangnirtung", TimeZones.lotusZones[13][1]),
	AMERICA_PARAMARIBO(180, TimeZones.lotusZones[28][0], "America/Paramaribo", TimeZones.lotusZones[28][1]),
	AMERICA_PHOENIX(181, TimeZones.lotusZones[8][0], "America/Phoenix", TimeZones.lotusZones[8][1]),
	AMERICA_PORT_OF_SPAIN(182, TimeZones.lotusZones[21][0], "America/Port_of_Spain", TimeZones.lotusZones[21][1]),
	AMERICA_PORT_AU_PRINCE(183, TimeZones.lotusZones[14][0], "America/Port-au-Prince", TimeZones.lotusZones[14][1]),
	AMERICA_PORTO_ACRE(184, TimeZones.lotusZones[14][0], "America/Porto_Acre", TimeZones.lotusZones[14][1]),
	AMERICA_PORTO_VELHO(185, TimeZones.lotusZones[21][0], "America/Porto_Velho", TimeZones.lotusZones[21][1]),
	AMERICA_PUERTO_RICO(186, TimeZones.lotusZones[21][0], "America/Puerto_Rico", TimeZones.lotusZones[21][1]),
	AMERICA_RAINY_RIVER(187, TimeZones.lotusZones[11][0], "America/Rainy_River", TimeZones.lotusZones[11][1]),
	AMERICA_RANKIN_INLET(188, TimeZones.lotusZones[11][0], "America/Rankin_Inlet", TimeZones.lotusZones[11][1]),
	AMERICA_RECIFE(189, TimeZones.lotusZones[28][0], "America/Recife", TimeZones.lotusZones[28][1]),
	AMERICA_REGINA(190, TimeZones.lotusZones[9][0], "America/Regina", TimeZones.lotusZones[9][1]),
	AMERICA_RESOLUTE(191, TimeZones.lotusZones[11][0], "America/Resolute", TimeZones.lotusZones[11][1]),
	AMERICA_RIO_BRANCO(192, TimeZones.lotusZones[14][0], "America/Rio_Branco", TimeZones.lotusZones[14][1]),
	AMERICA_ROSARIO(193, TimeZones.lotusZones[23][0], "America/Rosario", TimeZones.lotusZones[23][1]),
	AMERICA_SANTA_ISABEL(194, TimeZones.lotusZones[5][0], "America/Santa_Isabel", TimeZones.lotusZones[5][1]),
	AMERICA_SANTAREM(195, TimeZones.lotusZones[28][0], "America/Santarem", TimeZones.lotusZones[28][1]),
	AMERICA_SANTIAGO(196, TimeZones.lotusZones[19][0], "America/Santiago", TimeZones.lotusZones[19][1]),
	AMERICA_SANTO_DOMINGO(197, TimeZones.lotusZones[21][0], "America/Santo_Domingo", TimeZones.lotusZones[21][1]),
	AMERICA_SAO_PAULO(198, TimeZones.lotusZones[25][0], "America/Sao_Paulo", TimeZones.lotusZones[25][1]),
	AMERICA_SCORESBYSUND(199, TimeZones.lotusZones[31][0], "America/Scoresbysund", TimeZones.lotusZones[31][1]),
	AMERICA_SHIPROCK(200, TimeZones.lotusZones[6][0], "America/Shiprock", TimeZones.lotusZones[6][1]),
	AMERICA_SITKA(201, TimeZones.lotusZones[3][0], "America/Sitka", TimeZones.lotusZones[3][1]),
	AMERICA_ST_BARTHELEMY(202, TimeZones.lotusZones[21][0], "America/St_Barthelemy", TimeZones.lotusZones[21][1]),
	AMERICA_ST_JOHNS(203, TimeZones.lotusZones[22][0], "America/St_Johns", TimeZones.lotusZones[22][1]),
	AMERICA_ST_KITTS(204, TimeZones.lotusZones[21][0], "America/St_Kitts", TimeZones.lotusZones[21][1]),
	AMERICA_ST_LUCIA(205, TimeZones.lotusZones[21][0], "America/St_Lucia", TimeZones.lotusZones[21][1]),
	AMERICA_ST_THOMAS(206, TimeZones.lotusZones[21][0], "America/St_Thomas", TimeZones.lotusZones[21][1]),
	AMERICA_ST_VINCENT(207, TimeZones.lotusZones[21][0], "America/St_Vincent", TimeZones.lotusZones[21][1]),
	AMERICA_SWIFT_CURRENT(208, TimeZones.lotusZones[9][0], "America/Swift_Current", TimeZones.lotusZones[9][1]),
	AMERICA_TEGUCIGALPA(209, TimeZones.lotusZones[10][0], "America/Tegucigalpa", TimeZones.lotusZones[10][1]),
	AMERICA_THULE(210, TimeZones.lotusZones[17][0], "America/Thule", TimeZones.lotusZones[17][1]),
	AMERICA_THUNDER_BAY(211, TimeZones.lotusZones[13][0], "America/Thunder_Bay", TimeZones.lotusZones[13][1]),
	AMERICA_TIJUANA(212, TimeZones.lotusZones[5][0], "America/Tijuana", TimeZones.lotusZones[5][1]),
	AMERICA_TORONTO(213, TimeZones.lotusZones[13][0], "America/Toronto", TimeZones.lotusZones[13][1]),
	AMERICA_TORTOLA(214, TimeZones.lotusZones[21][0], "America/Tortola", TimeZones.lotusZones[21][1]),
	AMERICA_VANCOUVER(215, TimeZones.lotusZones[4][0], "America/Vancouver", TimeZones.lotusZones[4][1]),
	AMERICA_VIRGIN(216, TimeZones.lotusZones[21][0], "America/Virgin", TimeZones.lotusZones[21][1]),
	AMERICA_WHITEHORSE(217, TimeZones.lotusZones[4][0], "America/Whitehorse", TimeZones.lotusZones[4][1]),
	AMERICA_WINNIPEG(218, TimeZones.lotusZones[11][0], "America/Winnipeg", TimeZones.lotusZones[11][1]),
	AMERICA_YAKUTAT(219, TimeZones.lotusZones[3][0], "America/Yakutat", TimeZones.lotusZones[3][1]),
	AMERICA_YELLOWKNIFE(220, TimeZones.lotusZones[6][0], "America/Yellowknife", TimeZones.lotusZones[6][1]),
	ANTARCTICA_CASEY(221, TimeZones.lotusZones[85][0], "Antarctica/Casey", TimeZones.lotusZones[85][1]),
	ANTARCTICA_DAVIS(222, TimeZones.lotusZones[79][0], "Antarctica/Davis", TimeZones.lotusZones[79][1]),
	ANTARCTICA_DUMONTDURVILLE(223, TimeZones.lotusZones[96][0], "Antarctica/DumontDUrville", TimeZones.lotusZones[96][1]),
	ANTARCTICA_MACQUARIE(224, TimeZones.lotusZones[97][0], "Antarctica/Macquarie", TimeZones.lotusZones[97][1]),
	ANTARCTICA_MAWSON(225, TimeZones.lotusZones[70][0], "Antarctica/Mawson", TimeZones.lotusZones[70][1]),
	ANTARCTICA_MCMURDO(226, TimeZones.lotusZones[101][0], "Antarctica/McMurdo", TimeZones.lotusZones[101][1]),
	ANTARCTICA_PALMER(227, TimeZones.lotusZones[17][0], "Antarctica/Palmer", TimeZones.lotusZones[17][1]),
	ANTARCTICA_ROTHERA(228, TimeZones.lotusZones[24][0], "Antarctica/Rothera", TimeZones.lotusZones[24][1]),
	ANTARCTICA_SOUTH_POLE(229, TimeZones.lotusZones[101][0], "Antarctica/South_Pole", TimeZones.lotusZones[101][1]),
	ANTARCTICA_SYOWA(230, TimeZones.lotusZones[58][0], "Antarctica/Syowa", TimeZones.lotusZones[58][1]),
	ANTARCTICA_TROLL(231, TimeZones.lotusZones[33][0], "Antarctica/Troll", TimeZones.lotusZones[33][1]), // no equivalent in Lotus zones
	ANTARCTICA_VOSTOK(232, TimeZones.lotusZones[76][0], "Antarctica/Vostok", TimeZones.lotusZones[76][1]),
	ARCTIC_LONGYEARBYEN(233, TimeZones.lotusZones[42][0], "Arctic/Longyearbyen", TimeZones.lotusZones[42][1]),
	ASIA_ADEN(234, TimeZones.lotusZones[55][0], "Asia/Aden", TimeZones.lotusZones[55][1]),
	ASIA_ALMATY(235, TimeZones.lotusZones[75][0], "Asia/Almaty", TimeZones.lotusZones[75][1]),
	ASIA_AMMAN(236, TimeZones.lotusZones[48][0], "Asia/Amman", TimeZones.lotusZones[48][1]),
	ASIA_ANADYR(237, TimeZones.lotusZones[102][0], "Asia/Anadyr", TimeZones.lotusZones[102][1]),
	ASIA_AQTAU(238, TimeZones.lotusZones[70][0], "Asia/Aqtau", TimeZones.lotusZones[70][1]),
	ASIA_AQTOBE(239, TimeZones.lotusZones[70][0], "Asia/Aqtobe", TimeZones.lotusZones[70][1]),
	ASIA_ASHGABAT(240, TimeZones.lotusZones[70][0], "Asia/Ashgabat", TimeZones.lotusZones[70][1]),
	ASIA_ASHKHABAT(241, TimeZones.lotusZones[70][0], "Asia/Ashkhabat", TimeZones.lotusZones[70][1]),
	ASIA_BAGHDAD(242, TimeZones.lotusZones[56][0], "Asia/Baghdad", TimeZones.lotusZones[56][1]),
	ASIA_BAHRAIN(243, TimeZones.lotusZones[55][0], "Asia/Bahrain", TimeZones.lotusZones[55][1]),
	ASIA_BAKU(244, TimeZones.lotusZones[63][0], "Asia/Baku", TimeZones.lotusZones[63][1]),
	ASIA_BANGKOK(245, TimeZones.lotusZones[79][0], "Asia/Bangkok", TimeZones.lotusZones[79][1]),
	ASIA_BARNAUL(246, TimeZones.lotusZones[78][0], "Asia/Barnaul", TimeZones.lotusZones[78][1]),
	ASIA_BEIRUT(247, TimeZones.lotusZones[51][0], "Asia/Beirut", TimeZones.lotusZones[51][1]),
	ASIA_BISHKEK(248, TimeZones.lotusZones[75][0], "Asia/Bishkek", TimeZones.lotusZones[75][1]),
	ASIA_BRUNEI(249, TimeZones.lotusZones[82][0], "Asia/Brunei", TimeZones.lotusZones[82][1]),
	ASIA_CALCUTTA(250, TimeZones.lotusZones[71][0], "Asia/Calcutta", TimeZones.lotusZones[71][1]),
	ASIA_CHITA(251, TimeZones.lotusZones[88][0], "Asia/Chita", TimeZones.lotusZones[88][1]),
	ASIA_CHOIBALSAN(252, TimeZones.lotusZones[80][0], "Asia/Choibalsan", TimeZones.lotusZones[80][1]),
	ASIA_CHONGQUING(253, TimeZones.lotusZones[80][0], "Asia/Chongquing", TimeZones.lotusZones[80][1]),
	ASIA_CHUNGKING(254, TimeZones.lotusZones[80][0], "Asia/Chungking", TimeZones.lotusZones[80][1]),
	ASIA_COLOMBO(255, TimeZones.lotusZones[72][0], "Asia/Colombo", TimeZones.lotusZones[72][1]),
	ASIA_DACCA(256, TimeZones.lotusZones[74][0], "Asia/Dacca", TimeZones.lotusZones[74][1]),
	ASIA_DAMASCUS(257, TimeZones.lotusZones[53][0], "Asia/Damascus", TimeZones.lotusZones[53][1]),
	ASIA_DHAKA(258, TimeZones.lotusZones[74][0], "Asia/Dhaka", TimeZones.lotusZones[74][1]),
	ASIA_DILI(259, TimeZones.lotusZones[86][0], "Asia/Dili", TimeZones.lotusZones[86][1]),
	ASIA_DUBAI(260, TimeZones.lotusZones[61][0], "Asia/Dubai", TimeZones.lotusZones[61][1]),
	ASIA_DUSHANBE(261, TimeZones.lotusZones[70][0], "Asia/Dushanbe", TimeZones.lotusZones[70][1]),
	ASIA_GAZA(262, TimeZones.lotusZones[47][0], "Asia/Gaza", TimeZones.lotusZones[47][1]),
	ASIA_HARBIN(263, TimeZones.lotusZones[80][0], "Asia/Harbin", TimeZones.lotusZones[80][1]),
	ASIA_HEBRON(264, TimeZones.lotusZones[47][0], "Asia/Hebron", TimeZones.lotusZones[47][1]),
	ASIA_HO_CHI_MINH(265, TimeZones.lotusZones[79][0], "Asia/Ho_Chi_Minh", TimeZones.lotusZones[79][1]),
	ASIA_HONG_KONG(266, TimeZones.lotusZones[80][0], "Asia/Hong_Kong", TimeZones.lotusZones[80][1]),
	ASIA_HOVD(267, TimeZones.lotusZones[79][0], "Asia/Hovd", TimeZones.lotusZones[79][1]), // no equivalent in Lotus time zones
	ASIA_IRKUTSK(268, TimeZones.lotusZones[81][0], "Asia/Irkutsk", TimeZones.lotusZones[81][1]),
	ASIA_ISTANBUL(269, TimeZones.lotusZones[54][0], "Asia/Istanbul", TimeZones.lotusZones[54][1]),
	ASIA_JAKARTA(270, TimeZones.lotusZones[79][0], "Asia/Jakarta", TimeZones.lotusZones[79][1]),
	ASIA_JAYAPURA(271, TimeZones.lotusZones[86][0], "Asia/Jayapura", TimeZones.lotusZones[86][1]),
	ASIA_JERUSALEM(272, TimeZones.lotusZones[47][0], "Asia/Jerusalem", TimeZones.lotusZones[47][1]),
	ASIA_KABUL(273, TimeZones.lotusZones[67][0], "Asia/Kabul", TimeZones.lotusZones[67][1]),
	ASIA_KAMCHATKA(274, TimeZones.lotusZones[102][0], "Asia/Kamchatka", TimeZones.lotusZones[102][1]),
	ASIA_KARACHI(275, TimeZones.lotusZones[69][0], "Asia/Karachi", TimeZones.lotusZones[69][1]),
	ASIA_KASHGAR(276, TimeZones.lotusZones[75][0], "Asia/Kashgar", TimeZones.lotusZones[75][1]),
	ASIA_KATHMANDU(277, TimeZones.lotusZones[73][0], "Asia/Kathmandu", TimeZones.lotusZones[73][1]),
	ASIA_KATMANDU(278, TimeZones.lotusZones[73][0], "Asia/Katmandu", TimeZones.lotusZones[73][1]),
	ASIA_KHANDYGA(279, TimeZones.lotusZones[88][0], "Asia/Khandyga", TimeZones.lotusZones[88][1]),
	ASIA_KOLKATTA(280, TimeZones.lotusZones[71][0], "Asia/Kolkatta", TimeZones.lotusZones[71][1]),
	ASIA_KRASNOYARSK(281, TimeZones.lotusZones[78][0], "Asia/Krasnoyarsk", TimeZones.lotusZones[78][1]),
	ASIA_KUALA_LUMPUR(282, TimeZones.lotusZones[82][0], "Asia/Kuala_Lumpur", TimeZones.lotusZones[82][1]),
	ASIA_KUCHING(283, TimeZones.lotusZones[83][0], "Asia/Kuching", TimeZones.lotusZones[83][1]),
	ASIA_KUWAIT(284, TimeZones.lotusZones[55][0], "Asia/Kuwait", TimeZones.lotusZones[55][1]),
	ASIA_MACAO(285, TimeZones.lotusZones[83][0], "Asia/Macao", TimeZones.lotusZones[83][1]),
	ASIA_MACAU(286, TimeZones.lotusZones[83][0], "Asia/Macau", TimeZones.lotusZones[83][1]),
	ASIA_MAGADAN(287, TimeZones.lotusZones[98][0], "Asia/Magadan", TimeZones.lotusZones[98][1]),
	ASIA_MAKASSAR(288, TimeZones.lotusZones[83][0], "Asia/Makassar", TimeZones.lotusZones[83][1]),
	ASIA_MANILA(289, TimeZones.lotusZones[83][0], "Asia/Manila", TimeZones.lotusZones[83][1]),
	ASIA_MUSKAT(290, TimeZones.lotusZones[61][0], "Asia/Muskat", TimeZones.lotusZones[61][1]),
	ASIA_NICOSIA(291, TimeZones.lotusZones[47][0], "Asia/Nicosia", TimeZones.lotusZones[47][1]),
	ASIA_NOVOKUZNETSK(292, TimeZones.lotusZones[78][0], "Asia/Novokuznetsk", TimeZones.lotusZones[78][1]),
	ASIA_NOVOSIBIRSK(293, TimeZones.lotusZones[76][0], "Asia/Novosibirsk", TimeZones.lotusZones[76][1]),
	ASIA_OMSK(294, TimeZones.lotusZones[78][0], "Asia/Omsk", TimeZones.lotusZones[78][1]),
	ASIA_ORAL(295, TimeZones.lotusZones[70][0], "Asia/Oral", TimeZones.lotusZones[70][1]),
	ASIA_PHNOM_PENH(296, TimeZones.lotusZones[79][0], "Asia/Phnom_Pehn", TimeZones.lotusZones[79][1]),
	ASIA_PONTIANAK(297, TimeZones.lotusZones[79][0], "Asia/Pontianak", TimeZones.lotusZones[79][1]),
	ASIA_PYONGYANG(298, TimeZones.lotusZones[80][0], "Asia/Pyongyang", TimeZones.lotusZones[80][1]), // no equivalent in Lotus time zones
	ASIA_QATAR(299, TimeZones.lotusZones[55][0], "Asia/Qatar", TimeZones.lotusZones[55][1]),
	ASIA_QYZYLORDA(300, TimeZones.lotusZones[75][0], "Asia/Quizilorda", TimeZones.lotusZones[75][1]),
	ASIA_RANGOON(301, TimeZones.lotusZones[77][0], "Asia/Rangoon", TimeZones.lotusZones[77][1]),
	ASIA_RIYADH(302, TimeZones.lotusZones[55][0], "Asia/Riyadh", TimeZones.lotusZones[55][1]),
	ASIA_SAIGON(303, TimeZones.lotusZones[79][0], "Asia/Saigon", TimeZones.lotusZones[79][1]),
	ASIA_SAKHALIN(304, TimeZones.lotusZones[98][0], "Asia/Sakhalin", TimeZones.lotusZones[98][1]),
	ASIA_SAMARKAND(305, TimeZones.lotusZones[70][0], "Asia/Samarkand", TimeZones.lotusZones[70][1]),
	ASIA_SEOUL(306, TimeZones.lotusZones[86][0], "Asia/Seoul", TimeZones.lotusZones[86][1]),
	ASIA_SHANGHAI(307, TimeZones.lotusZones[80][0], "Asia/Shanghai", TimeZones.lotusZones[80][1]),
	ASIA_SINGAPORE(308, TimeZones.lotusZones[82][0], "Asia/Singapore", TimeZones.lotusZones[82][1]),
	ASIA_SREDNEKOLYMSK(309, TimeZones.lotusZones[98][0], "Asia/Srednekolymsk", TimeZones.lotusZones[98][1]),
	ASIA_TAIPEI(310, TimeZones.lotusZones[83][0], "Asia/Taipei", TimeZones.lotusZones[83][1]),
	ASIA_TASHKENT(311, TimeZones.lotusZones[70][0], "Asia/Tashkent", TimeZones.lotusZones[70][1]),
	ASIA_TBILISI(312, TimeZones.lotusZones[64][0], "Asia/Tbilisi", TimeZones.lotusZones[64][1]),
	ASIA_TEHRAN(313, TimeZones.lotusZones[60][0], "Asia/Tehran", TimeZones.lotusZones[60][1]),
	ASIA_TEL_AVIV(314, TimeZones.lotusZones[47][0], "Asia/Tel_Aviv", TimeZones.lotusZones[47][1]),
	ASIA_THIMBU(315, TimeZones.lotusZones[74][0], "Asia/Thimbu", TimeZones.lotusZones[74][1]),
	ASIA_THIMPHU(316, TimeZones.lotusZones[74][0], "Asia/Thimphu", TimeZones.lotusZones[74][1]),
	ASIA_TOKYO(317, TimeZones.lotusZones[87][0], "Asia/Tokyo", TimeZones.lotusZones[87][1]),
	ASIA_TOMSK(318, TimeZones.lotusZones[78][0], "Asia/Tomsk", TimeZones.lotusZones[78][1]),
	ASIA_UJUNG_PANDANG(319, TimeZones.lotusZones[82][0], "Asia/Ujung_Pandang", TimeZones.lotusZones[82][1]),
	ASIA_ULANBATAAR(320, TimeZones.lotusZones[84][0], "Asia/Ulanbataar", TimeZones.lotusZones[84][1]),
	ASIA_URUMQI(321, TimeZones.lotusZones[74][0], "Asia/Urumqi", TimeZones.lotusZones[74][1]),
	ASIA_UST_NERA(322, TimeZones.lotusZones[95][0], "Asia/Ust-Nera", TimeZones.lotusZones[95][1]),
	ASIA_VIENTIANE(323, TimeZones.lotusZones[79][0], "Asia/Vientiane", TimeZones.lotusZones[79][1]),
	ASIA_VLADIVOSTOK(324, TimeZones.lotusZones[95][0], "Asia/Vladivostok", TimeZones.lotusZones[95][1]),
	ASIA_YAKUTSK(325, TimeZones.lotusZones[88][0], "Asia/Yakutsk", TimeZones.lotusZones[88][1]),
	ASIA_YEKATERINBURG(326, TimeZones.lotusZones[68][0], "Asia/Yekaterinburg", TimeZones.lotusZones[68][1]),
	ASIA_YEREVAN(327, TimeZones.lotusZones[63][0], "Asia/Yerevan", TimeZones.lotusZones[63][1]),
	ATLANTIC_AZORES(328, TimeZones.lotusZones[31][0], "Atlantic/Azores", TimeZones.lotusZones[31][1]),
	ATLANTIC_BERMUDA(329, TimeZones.lotusZones[17][0], "Atlantic/Bermuda", TimeZones.lotusZones[17][1]),
	ATLANTIC_CANARY(330, TimeZones.lotusZones[33][0], "Atlantic/Canary", TimeZones.lotusZones[33][1]),
	ATLANTIC_CAPE_VERDE(331, TimeZones.lotusZones[41][0], "Atlantic/Cape_Verde", TimeZones.lotusZones[41][1]),
	ATLANTIC_FAEROE(332, TimeZones.lotusZones[33][0], "Atlantic/Faeroe", TimeZones.lotusZones[33][1]),
	ATLANTIC_FAROE(333, TimeZones.lotusZones[33][0], "Atlantic/Faroe", TimeZones.lotusZones[33][1]),
	ATLANTIC_JAN_MAYEN(334, TimeZones.lotusZones[42][0], "Atlantic/Jan_Mayen", TimeZones.lotusZones[42][1]),
	ATLANTIC_MADEIRA(335, TimeZones.lotusZones[33][0], "Atlantic/Madeira", TimeZones.lotusZones[33][1]),
	ATLANTIC_REYKJAVIK(336, TimeZones.lotusZones[34][0], "Atlantic/Reykjavik", TimeZones.lotusZones[34][1]),
	ATLANTIC_SOUTH_GEORGIA(337, TimeZones.lotusZones[30][0], "Atlantic/South_Georgia", TimeZones.lotusZones[30][1]),
	ATLANTIC_ST_HELENA(338, TimeZones.lotusZones[34][0], "Atlantic/St_Helena", TimeZones.lotusZones[34][1]),
	ATLANTIC_STANLEY(339, TimeZones.lotusZones[28][0], "Atlantic/Stanley", TimeZones.lotusZones[28][1]),
	AUSTRALIA_ACT(340, TimeZones.lotusZones[91][0], "Australia/ACT", TimeZones.lotusZones[91][1]),
	AUSTRALIA_ADELAIDE(341, TimeZones.lotusZones[90][0], "Australia/Adelaide", TimeZones.lotusZones[90][1]),
	AUSTRALIA_BRISBANE(342, TimeZones.lotusZones[92][0], "Australia/Brisbane", TimeZones.lotusZones[92][1]),
	AUSTRALIA_BROKEN_HILL(343, TimeZones.lotusZones[90][0], "Australia/Broken_Hill", TimeZones.lotusZones[90][1]),
	AUSTRALIA_CANBERRA(344, TimeZones.lotusZones[91][0], "Australia/Canberra", TimeZones.lotusZones[91][1]),
	AUSTRALIA_CURRIE(345, TimeZones.lotusZones[94][0], "Australia/Currie", TimeZones.lotusZones[94][1]),
	AUSTRALIA_DARWIN(346, TimeZones.lotusZones[89][0], "Australia/Darwin", TimeZones.lotusZones[89][1]),
	AUSTRALIA_EUCLA(347, TimeZones.lotusZones[87][0], "Australia/Eucla", TimeZones.lotusZones[87][1]), // no equivalent in Lotus time zones
	AUSTRALIA_HOBART(348, TimeZones.lotusZones[94][0], "Australia/Hobart", TimeZones.lotusZones[94][1]),
	AUSTRALIA_LHI(349, TimeZones.lotusZones[92][0], "Australia/LHI", TimeZones.lotusZones[92][1]), // no equivalent in Lotus time zones
	AUSTRALIA_LINDEMAN(350, TimeZones.lotusZones[92][0], "Australia/Lindeman", TimeZones.lotusZones[92][1]),
	AUSTRALIA_LORD_HOWE(351, TimeZones.lotusZones[92][0], "Australia/Lord_Howe", TimeZones.lotusZones[92][1]), // no equivalent in Lotus time zones
	AUSTRALIA_MELBOURNE(352, TimeZones.lotusZones[91][0], "Australia/Melbourne", TimeZones.lotusZones[91][1]),
	AUSTRALIA_NORTH(353, TimeZones.lotusZones[89][0], "Australia/North", TimeZones.lotusZones[89][1]),
	AUSTRALIA_NSW(354, TimeZones.lotusZones[91][0], "Australia/NSW", TimeZones.lotusZones[91][1]),
	AUSTRALIA_PERTH(355, TimeZones.lotusZones[85][0], "Australia/Perth", TimeZones.lotusZones[85][1]),
	AUSTRALIA_QUEENSLAND(356, TimeZones.lotusZones[91][0], "Australia/Queensland", TimeZones.lotusZones[91][1]),
	AUSTRALIA_SOUTH(357, TimeZones.lotusZones[90][0], "Australia/South", TimeZones.lotusZones[90][1]),
	AUSTRALIA_SYDNEY(358, TimeZones.lotusZones[91][0], "Australia/Sydney", TimeZones.lotusZones[91][1]),
	AUSTRALIA_TASMANIA(359, TimeZones.lotusZones[94][0], "Australia/Tasmania", TimeZones.lotusZones[94][1]),
	AUSTRALIA_VICTORIA(360, TimeZones.lotusZones[91][0], "Australia/Victoria", TimeZones.lotusZones[91][1]),
	AUSTRALIA_WEST(361, TimeZones.lotusZones[85][0], "Australia/West", TimeZones.lotusZones[85][1]),
	AUSTRALIA_YANCOWINNA(362, TimeZones.lotusZones[90][0], "Australia/Yancowinna", TimeZones.lotusZones[90][1]),
	BRAZIL_ACRE(363, TimeZones.lotusZones[14][0], "Brazil/Acre", TimeZones.lotusZones[14][1]),
	BRAZIL_DENORONHA(364, TimeZones.lotusZones[30][0], "Brazil/DeNoronha", TimeZones.lotusZones[30][1]),
	BRAZIL_EAST(365, TimeZones.lotusZones[25][0], "Brazil/East", TimeZones.lotusZones[25][1]),
	BRAZIL_WEST(366, TimeZones.lotusZones[21][0], "Brazil/West", TimeZones.lotusZones[21][1]),
	CANADA_ATLANTIC(367, TimeZones.lotusZones[17][0], "Canada/Atlantic", TimeZones.lotusZones[17][1]),
	CANADA_CENTRAL(368, TimeZones.lotusZones[11][0], "Canada/Central", TimeZones.lotusZones[11][1]),
	CANADA_EASTERN(369, TimeZones.lotusZones[13][0], "Canada/Atlantic", TimeZones.lotusZones[13][1]),
	CANADA_EAST_SASKATCHEWAN(370, TimeZones.lotusZones[9][0], "Canada/East-Saskatchewan", TimeZones.lotusZones[9][1]),
	CANADA_MOUNTAIN(371, TimeZones.lotusZones[6][0], "Canada/Mountain", TimeZones.lotusZones[6][1]),
	CANADA_NEWFOUNDLAND(372, TimeZones.lotusZones[22][0], "Canada/Newfoundland", TimeZones.lotusZones[22][1]),
	CANADA_PACIFIC(373, TimeZones.lotusZones[4][0], "Canada/Pacific", TimeZones.lotusZones[4][1]),
	CANADA_SASKATCHEWAN(374, TimeZones.lotusZones[9][0], "Canada/Saskatchewan", TimeZones.lotusZones[9][1]),
	CANADA_YUKON(375, TimeZones.lotusZones[4][0], "Canada/Yukon", TimeZones.lotusZones[4][1]),
	CET(376, TimeZones.lotusZones[38][0], "CET", TimeZones.lotusZones[38][1]),
	CHILE_CONTINENTAL(377, TimeZones.lotusZones[19][0], "Chile/Continental", TimeZones.lotusZones[19][1]),
	CHILE_EASTERISLAND(378, TimeZones.lotusZones[11][0], "Chile/EasterIsland", TimeZones.lotusZones[11][1]),
	CST6CDT(379, TimeZones.lotusZones[11][0], "CST6CDT", TimeZones.lotusZones[11][1]),
	CUBA(380, TimeZones.lotusZones[13][0], "Cuba", TimeZones.lotusZones[13][1]),
	EET(381, TimeZones.lotusZones[45][0], "EET", TimeZones.lotusZones[45][1]),
	EGYPT(382, TimeZones.lotusZones[44][0], "Egypt", TimeZones.lotusZones[44][1]),
	EIRE(383, TimeZones.lotusZones[33][0], "Eire", TimeZones.lotusZones[33][1]),
	EST(384, TimeZones.lotusZones[14][0], "EST", TimeZones.lotusZones[14][1]),
	EST5EDT(385, TimeZones.lotusZones[13][0], "EST5EDT", TimeZones.lotusZones[13][1]),
	ETC_GMT(386, TimeZones.lotusZones[34][0], "Etc/GMT", TimeZones.lotusZones[34][1]),
	ETC_GMT_P0(387, TimeZones.lotusZones[34][0], "Etc/GMT +0", TimeZones.lotusZones[34][1]),
	ETC_GMT_P1(388, TimeZones.lotusZones[32][0], "Etc/GMT +1", TimeZones.lotusZones[32][1]),
	ETC_GMT_P10(389, TimeZones.lotusZones[2][0], "Etc/GMT +10", TimeZones.lotusZones[2][1]),
	ETC_GMT_P11(390, TimeZones.lotusZones[1][0], "Etc/GMT +11", TimeZones.lotusZones[1][1]),
	ETC_GMT_P12(391, TimeZones.lotusZones[0][0], "Etc/GMT +12", TimeZones.lotusZones[0][1]),
	ETC_GMT_P2(392, TimeZones.lotusZones[30][0], "Etc/GMT +2", TimeZones.lotusZones[30][1]),
	ETC_GMT_P3(393, TimeZones.lotusZones[28][0], "Etc/GMT +3", TimeZones.lotusZones[28][1]),
	ETC_GMT_P4(394, TimeZones.lotusZones[21][0], "Etc/GMT +4", TimeZones.lotusZones[21][1]),
	ETC_GMT_P5(395, TimeZones.lotusZones[14][0], "Etc/GMT +5", TimeZones.lotusZones[14][1]),
	ETC_GMT_P6(396, TimeZones.lotusZones[10][0], "Etc/GMT +6", TimeZones.lotusZones[10][1]),
	ETC_GMT_P7(397, TimeZones.lotusZones[8][0], "Etc/GMT +7", TimeZones.lotusZones[8][1]),
	ETC_GMT_P8(398, TimeZones.lotusZones[4][0], "Etc/GMT +8", TimeZones.lotusZones[4][1]), // no equivalent
	ETC_GMT_P9(399, TimeZones.lotusZones[3][0], "Etc/GMT +9", TimeZones.lotusZones[3][1]), // no equivalent
	ETC_GMT_0(400, TimeZones.lotusZones[34][0], "Etc/GMT 0", TimeZones.lotusZones[34][1]),
	ETC_GMT_M0(401, TimeZones.lotusZones[34][0], "Etc/GMT -0", TimeZones.lotusZones[34][1]),
	ETC_GMT_M1(402, TimeZones.lotusZones[41][0], "Etc/GMT -1", TimeZones.lotusZones[41][1]),
	ETC_GMT_M10(403, TimeZones.lotusZones[92][0], "Etc/GMT -10", TimeZones.lotusZones[92][1]),
	ETC_GMT_M11(404, TimeZones.lotusZones[97][0], "Etc/GMT -11", TimeZones.lotusZones[97][1]),
	ETC_GMT_M12(405, TimeZones.lotusZones[103][0], "Etc/GMT -12", TimeZones.lotusZones[103][1]),
	ETC_GMT_M2(406, TimeZones.lotusZones[44][0], "Etc/GMT -2", TimeZones.lotusZones[44][1]),
	ETC_GMT_M3(407, TimeZones.lotusZones[55][0], "Etc/GMT -3", TimeZones.lotusZones[55][1]),
	ETC_GMT_M4(408, TimeZones.lotusZones[61][0], "Etc/GMT -4", TimeZones.lotusZones[61][1]),
	ETC_GMT_M5(409, TimeZones.lotusZones[68][0], "Etc/GMT -5", TimeZones.lotusZones[68][1]),
	ETC_GMT_M6(410, TimeZones.lotusZones[74][0], "Etc/GMT -6", TimeZones.lotusZones[74][1]),
	ETC_GMT_M7(411, TimeZones.lotusZones[78][0], "Etc/GMT -7", TimeZones.lotusZones[78][1]),
	ETC_GMT_M8(412, TimeZones.lotusZones[80][0], "Etc/GMT -8", TimeZones.lotusZones[80][1]),
	ETC_GMT_M9(413, TimeZones.lotusZones[86][0], "Etc/GMT -9", TimeZones.lotusZones[86][1]),
	ETC_GREENWHICH(414, TimeZones.lotusZones[34][0], "Etc/Greenwhich", TimeZones.lotusZones[34][1]),
	ETC_UTC(415, TimeZones.lotusZones[34][0], "Etc/UTC", TimeZones.lotusZones[34][1]),
	ETC_ZULU(416, TimeZones.lotusZones[34][0], "Etc/Zulu", TimeZones.lotusZones[34][1]),
	EUROPE_AMSTERDAM(417, TimeZones.lotusZones[42][0], "Europe/Amsterdam", TimeZones.lotusZones[42][1]),
	EUROPE_ANDORRA(418, TimeZones.lotusZones[40][0], "Europe/Andorra", TimeZones.lotusZones[40][1]),
	EUROPE_ASTRAKHAN(419, TimeZones.lotusZones[66][0], "Europe/Astrakhan", TimeZones.lotusZones[66][1]),
	EUROPE_ATHENS(420, TimeZones.lotusZones[46][0], "Europe/Athens", TimeZones.lotusZones[46][1]),
	EUROPE_BELFAST(421, TimeZones.lotusZones[33][0], "Europe/Belfast", TimeZones.lotusZones[33][1]),
	EUROPE_BELGRADE(422, TimeZones.lotusZones[37][0], "Europe/Belgrade", TimeZones.lotusZones[37][1]),
	EUROPE_BERLIN(423, TimeZones.lotusZones[42][0], "Europe/Berlin", TimeZones.lotusZones[42][1]),
	EUROPE_BRATISLAVA(424, TimeZones.lotusZones[37][0], "Europe/Bratislava", TimeZones.lotusZones[37][1]),
	EUROPE_BRUSSELS(425, TimeZones.lotusZones[40][0], "Europe/Brussels", TimeZones.lotusZones[40][1]),
	EUROPE_BUCHAREST(426, TimeZones.lotusZones[46][0], "Europe/Bucharest", TimeZones.lotusZones[46][1]),
	EUROPE_BUDAPEST(427, TimeZones.lotusZones[37][0], "Europe/Budapest", TimeZones.lotusZones[37][1]),
	EUROPE_BUSINGEN(428, TimeZones.lotusZones[42][0], "Europe/Busingen", TimeZones.lotusZones[42][1]),
	EUROPE_CHISINAU(429, TimeZones.lotusZones[46][0], "Europe/Chisinau", TimeZones.lotusZones[46][1]),
	EUROPE_COPENHAGEN(430, TimeZones.lotusZones[40][0], "Europe/Copenhagen", TimeZones.lotusZones[40][1]),
	EUROPE_DUBLIN(431, TimeZones.lotusZones[33][0], "Europe/Dublin", TimeZones.lotusZones[33][1]),
	EUROPE_GIBRALTAR(432, TimeZones.lotusZones[40][0], "Europe/Gibraltar", TimeZones.lotusZones[40][1]),
	EUROPE_GUERNSEY(433, TimeZones.lotusZones[33][0], "Europe/Guernsey", TimeZones.lotusZones[33][1]),
	EUROPE_HELSINKI(434, TimeZones.lotusZones[45][0], "Europe/Helsinki", TimeZones.lotusZones[45][1]),
	EUROPE_ISLE_OF_MAN(435, TimeZones.lotusZones[33][0], "Europe/Isle_of_Man", TimeZones.lotusZones[33][1]),
	EUROPE_ISTANBUL(436, TimeZones.lotusZones[54][0], "Europe/Istanbul", TimeZones.lotusZones[54][1]),
	EUROPE_JERSEY(437, TimeZones.lotusZones[33][0], "Europe/Jersey", TimeZones.lotusZones[33][1]),
	EUROPE_KALININGRAD(438, TimeZones.lotusZones[49][0], "Europe/Kaliningrad", TimeZones.lotusZones[49][1]),
	EUROPE_KIEV(439, TimeZones.lotusZones[45][0], "Europe/Kiev", TimeZones.lotusZones[45][1]),
	EUROPE_KIROV(440, TimeZones.lotusZones[59][0], "Europe/Kirov", TimeZones.lotusZones[59][1]),
	EUROPE_LISBON(441, TimeZones.lotusZones[33][0], "Europe/Lisbon", TimeZones.lotusZones[33][1]),
	EUROPE_LJUBLJANA(442, TimeZones.lotusZones[37][0], "Europe/Ljubljana", TimeZones.lotusZones[37][1]),
	EUROPE_LONDON(443, TimeZones.lotusZones[33][0], "Europe/London", TimeZones.lotusZones[33][1]),
	EUROPE_LUXEMBOURG(444, TimeZones.lotusZones[40][0], "Europe/Luxembourg", TimeZones.lotusZones[40][1]),
	EUROPE_MADRID(445, TimeZones.lotusZones[40][0], "Europe/Madrid", TimeZones.lotusZones[40][1]),
	EUROPE_MALTA(446, TimeZones.lotusZones[38][0], "Europe/Malta", TimeZones.lotusZones[38][1]),
	EUROPE_MARIEHAMM(447, TimeZones.lotusZones[45][0], "Europe/Mariehamm", TimeZones.lotusZones[45][1]),
	EUROPE_MINSK(448, TimeZones.lotusZones[57][0], "Europe/Minsk", TimeZones.lotusZones[57][1]),
	EUROPE_MONACO(449, TimeZones.lotusZones[40][0], "Europe/Monaco", TimeZones.lotusZones[40][1]),
	EUROPE_MOSCOW(450, TimeZones.lotusZones[59][0], "Europe/Moscow", TimeZones.lotusZones[59][1]),
	EUROPE_NICOSIA(451, TimeZones.lotusZones[47][0], "Europe/Nicosia", TimeZones.lotusZones[47][1]),
	EUROPE_OSLO(452, TimeZones.lotusZones[40][0], "Europe/Oslo", TimeZones.lotusZones[40][1]),
	EUROPE_PARIS(453, TimeZones.lotusZones[40][0], "Europe/Paris", TimeZones.lotusZones[40][1]),
	EUROPE_PODGORICA(454, TimeZones.lotusZones[37][0], "Europe/Podgorica", TimeZones.lotusZones[37][1]),
	EUROPE_PRAGUE(455, TimeZones.lotusZones[37][0], "Europe/Prague", TimeZones.lotusZones[37][1]),
	EUROPE_RIGA(456, TimeZones.lotusZones[45][0], "Europe/Riga", TimeZones.lotusZones[45][1]),
	EUROPE_ROME(457, TimeZones.lotusZones[42][0], "Europe/Rome", TimeZones.lotusZones[42][1]),
	EUROPE_SAMARA(458, TimeZones.lotusZones[66][0], "Europe/Samara", TimeZones.lotusZones[66][1]),
	EUROPE_SAN_MARINO(459, TimeZones.lotusZones[42][0], "Europe/San_Marino", TimeZones.lotusZones[42][1]),
	EUROPE_SARAJEVO(460, TimeZones.lotusZones[38][0], "Europe/Sarajevo", TimeZones.lotusZones[38][1]),
	EUROPE_SIMFEROPOL(461, TimeZones.lotusZones[59][0], "Europe/Simferopol", TimeZones.lotusZones[59][1]),
	EUROPE_SKOPJE(462, TimeZones.lotusZones[37][0], "Europe/Skopje", TimeZones.lotusZones[37][1]),
	EUROPE_SOFIA(463, TimeZones.lotusZones[45][0], "Europe/Sofia", TimeZones.lotusZones[45][1]),
	EUROPE_STOCKHOLM(464, TimeZones.lotusZones[42][0], "Europe/Stockholm", TimeZones.lotusZones[42][1]),
	EUROPE_TALINN(465, TimeZones.lotusZones[45][0], "Europe/Talinn", TimeZones.lotusZones[45][1]),
	EUROPE_TIRANE(466, TimeZones.lotusZones[38][0], "Europe/Tirane", TimeZones.lotusZones[38][1]),
	EUROPE_TIRASPOL(467, TimeZones.lotusZones[46][0], "Europe/Tiraspol", TimeZones.lotusZones[46][1]),
	EUROPE_ULYANOVSK(468, TimeZones.lotusZones[66][0], "Europe/Ulyanovsk", TimeZones.lotusZones[66][1]),
	EUROPE_UZHGOROD(469, TimeZones.lotusZones[45][0], "Europe/Uzhgorod", TimeZones.lotusZones[45][1]),
	EUROPE_VADUZ(470, TimeZones.lotusZones[42][0], "Europe/Vaduz", TimeZones.lotusZones[42][1]),
	EUROPE_VATICAN(471, TimeZones.lotusZones[42][0], "Europe/Vatican", TimeZones.lotusZones[42][1]),
	EUROPE_VIENNA(472, TimeZones.lotusZones[42][0], "Europe/Vienna", TimeZones.lotusZones[42][1]),
	EUROPE_VILNIUS(473, TimeZones.lotusZones[45][0], "Europe/Vilnius", TimeZones.lotusZones[45][1]),
	EUROPE_VOLGOGRAD(474, TimeZones.lotusZones[59][0], "Europe/Volgograd", TimeZones.lotusZones[59][1]),
	EUROPE_WARSAW(475, TimeZones.lotusZones[38][0], "Europe/Warsaw", TimeZones.lotusZones[38][1]),
	EUROPE_ZAGREB(476, TimeZones.lotusZones[37][0], "Europe/Zagreb", TimeZones.lotusZones[37][1]),
	EUROPE_ZAPOROZHYE(477, TimeZones.lotusZones[45][0], "Europe/Zaporozhye", TimeZones.lotusZones[45][1]),
	EUROPE_ZURICH(478, TimeZones.lotusZones[42][0], "Europe/Zurich", TimeZones.lotusZones[42][1]),
	GB(479, TimeZones.lotusZones[33][0], "GB", TimeZones.lotusZones[33][1]),
	GB_EIRE(480, TimeZones.lotusZones[33][0], "GB-Eire", TimeZones.lotusZones[33][1]),
	GMT(481, TimeZones.lotusZones[34][0], "GMT", TimeZones.lotusZones[34][1]),
	GMT_P0(482, TimeZones.lotusZones[34][0], "GMT+0", TimeZones.lotusZones[34][1]),
	GMT_0(483, TimeZones.lotusZones[34][0], "GMT0", TimeZones.lotusZones[34][1]),
	GMT_M0(484, TimeZones.lotusZones[34][0], "GMT-0", TimeZones.lotusZones[34][1]),
	GREENWHICH(485, TimeZones.lotusZones[34][0], "Greenwhich", TimeZones.lotusZones[34][1]),
	HONGKONG(486, TimeZones.lotusZones[80][0], "Hongkong", TimeZones.lotusZones[80][1]),
	HST(487, TimeZones.lotusZones[2][0], "HST", TimeZones.lotusZones[2][1]),
	ICELAND(488, TimeZones.lotusZones[34][0], "Iceland", TimeZones.lotusZones[34][1]),
	INDIAN_ANTANANARIVO(489, TimeZones.lotusZones[55][0], "Indian/Antananarivo", TimeZones.lotusZones[55][1]),
	INDIAN_CHAGOS(490, TimeZones.lotusZones[74][0], "Indian/Chagos", TimeZones.lotusZones[74][1]),
	INDIAN_CHRISTMAS(491, TimeZones.lotusZones[79][0], "Indian/Christmas", TimeZones.lotusZones[79][1]),
	INDIAN_COCOS(492, TimeZones.lotusZones[77][0], "Indian/Cocos", TimeZones.lotusZones[7][1]),
	INDIAN_COMORO(493, TimeZones.lotusZones[58][0], "Indian/Comoro", TimeZones.lotusZones[58][1]),
	INDIAN_KERGUELEN(494, TimeZones.lotusZones[69][0], "Indian/Kerguelen", TimeZones.lotusZones[69][1]),
	INDIAN_MAHE(495, TimeZones.lotusZones[61][0], "Indian/Mahe", TimeZones.lotusZones[61][1]),
	INDIAN_MALDIVES(496, TimeZones.lotusZones[69][0], "Indian/Maldives", TimeZones.lotusZones[69][1]),
	INDIAN_MAURITIUS(497, TimeZones.lotusZones[61][0], "Indian/Mauritius", TimeZones.lotusZones[61][1]),
	INDIAN_MAYOTTE(498, TimeZones.lotusZones[58][0], "Indian/Mayotte", TimeZones.lotusZones[58][1]),
	INDIAN_REUNION(499, TimeZones.lotusZones[61][0], "Indian/Reunion", TimeZones.lotusZones[61][1]),
	IRAN(500, TimeZones.lotusZones[60][0], "Iran", TimeZones.lotusZones[60][1]),
	ISRAEL(501, TimeZones.lotusZones[47][0], "Israel", TimeZones.lotusZones[47][1]),
	JAMAICA(502, TimeZones.lotusZones[14][0], "Jamaica", TimeZones.lotusZones[14][1]),
	JAPAN(503, TimeZones.lotusZones[87][0], "Japan", TimeZones.lotusZones[87][1]),
	KWAJALEIN(504, TimeZones.lotusZones[103][0], "Kwajalein", TimeZones.lotusZones[103][1]),
	LIBYA(505, TimeZones.lotusZones[50][0], "Libya", TimeZones.lotusZones[50][1]),
	MET(506, TimeZones.lotusZones[38][0], "MET", TimeZones.lotusZones[38][1]),
	MEXICO_BAJANORTE(507, TimeZones.lotusZones[5][0], "Mexico/BajaNorte", TimeZones.lotusZones[5][1]),
	MEXICO_BAJASUR(508, TimeZones.lotusZones[7][0], "Mexico/BajaSur", TimeZones.lotusZones[7][1]),
	MEXICO_GENERAL(509, TimeZones.lotusZones[12][0], "Mexico/General", TimeZones.lotusZones[12][1]),
	MST(510, TimeZones.lotusZones[8][0], "MST", TimeZones.lotusZones[8][1]),
	MST7MDT(511, TimeZones.lotusZones[6][0], "MST7MDT", TimeZones.lotusZones[6][1]),
	NAVAJO(512, TimeZones.lotusZones[6][0], "Navajo", TimeZones.lotusZones[6][1]),
	NZ(513, TimeZones.lotusZones[101][0], "NZ", TimeZones.lotusZones[101][1]),
	NZ_CHAT(514, TimeZones.lotusZones[104][0], "NZ-CHAT", TimeZones.lotusZones[104][1]),	// no equivalent
	PACIFIC_APIA(515, TimeZones.lotusZones[104][0], "Pacific/Apia", TimeZones.lotusZones[104][1]),
	PACIFIC_AUCKLAND(516, TimeZones.lotusZones[101][0], "Pacific/Auckland", TimeZones.lotusZones[101][1]),
	PACIFIC_BOUGAINVILLE(517, TimeZones.lotusZones[97][0], "Pacific/Bougainville", TimeZones.lotusZones[97][1]),
	PACIFIC_CHATHAM(518, TimeZones.lotusZones[104][0], "Pacific/Chatham", TimeZones.lotusZones[104][1]),	// no equivalent
	PACIFIC_CHUUK(519, TimeZones.lotusZones[96][0], "Pacific/Chuuk", TimeZones.lotusZones[96][1]),
	PACIFIC_EASTER(520, TimeZones.lotusZones[11][0], "Pacific/Easter", TimeZones.lotusZones[11][1]),
	PACIFIC_EFATE(521, TimeZones.lotusZones[97][0], "Pacific/Efate", TimeZones.lotusZones[97][1]),
	PACIFIC_ENDERBURY(522, TimeZones.lotusZones[105][0], "Pacific/Enderbury", TimeZones.lotusZones[105][1]),
	PACIFIC_FAKAOFO(523, TimeZones.lotusZones[105][0], "Pacific/Apia", TimeZones.lotusZones[105][1]),
	PACIFIC_FIJI(524, TimeZones.lotusZones[99][0], "Pacific/Fiji", TimeZones.lotusZones[99][1]),
	PACIFIC_FUNAFUTI(525, TimeZones.lotusZones[103][0], "Pacific/Funafuti", TimeZones.lotusZones[103][1]),
	PACIFIC_GALAPAGOS(526, TimeZones.lotusZones[10][0], "Pacific/Galapagos", TimeZones.lotusZones[10][1]),
	PACIFIC_GAMBIER(527, TimeZones.lotusZones[3][0], "Pacific/Gambier", TimeZones.lotusZones[3][1]),
	PACIFIC_GUADALCANAL(528, TimeZones.lotusZones[97][0], "Pacific/Guadalcanal", TimeZones.lotusZones[97][1]),
	PACIFIC_GUAM(529, TimeZones.lotusZones[96][0], "Pacific/Guam", TimeZones.lotusZones[96][1]),
	PACIFIC_HONOLULU(530, TimeZones.lotusZones[2][0], "Pacific/Honolulu", TimeZones.lotusZones[2][1]),
	PACIFIC_JOHNSTON(531, TimeZones.lotusZones[2][0], "Pacific/Johnston", TimeZones.lotusZones[2][1]),
	PACIFIC_KIRITIMATI(532, TimeZones.lotusZones[106][0], "Pacific/Kiritimati", TimeZones.lotusZones[106][1]),
	PACIFIC_KOSRAE(533, TimeZones.lotusZones[97][0], "Pacific/Kosrae", TimeZones.lotusZones[97][1]),
	PACIFIC_KWAJALEIN(534, TimeZones.lotusZones[103][0], "Pacific/Kwajalein", TimeZones.lotusZones[103][1]),
	PACIFIC_MAJURO(535, TimeZones.lotusZones[103][0], "Pacific/Majuro", TimeZones.lotusZones[103][1]),
	PACIFIC_MARQUESAS(536, TimeZones.lotusZones[3][0], "Pacific/Marquesas", TimeZones.lotusZones[3][1]),	// no equivalent
	PACIFIC_MIDWAY(537, TimeZones.lotusZones[1][0], "Pacific/Midway", TimeZones.lotusZones[1][1]),
	PACIFIC_NAURU(538, TimeZones.lotusZones[103][0], "Pacific/Nauru", TimeZones.lotusZones[103][1]),
	PACIFIC_NIUE(539, TimeZones.lotusZones[1][0], "Pacific/Niue", TimeZones.lotusZones[1][1]),
	PACIFIC_NORFOLK(540, TimeZones.lotusZones[97][0], "Pacific/Norfolk", TimeZones.lotusZones[97][1]),
	PACIFIC_NOUMEA(541, TimeZones.lotusZones[97][0], "Pacific/Noumea", TimeZones.lotusZones[97][1]),
	PACIFIC_PAGO_PAGO(542, TimeZones.lotusZones[1][0], "Pacific/Pago_Page", TimeZones.lotusZones[1][1]),
	PACIFIC_PALAU(543, TimeZones.lotusZones[87][0], "Pacific/Palau", TimeZones.lotusZones[87][1]),
	PACIFIC_PITCAIRN(544, TimeZones.lotusZones[4][0], "Pacific/Pitcairn", TimeZones.lotusZones[4][1]),	// no equivalent
	PACIFIC_POHNPEI(545, TimeZones.lotusZones[97][0], "Pacific/Pohnpei", TimeZones.lotusZones[97][1]),
	PACIFIC_PONAPE(546, TimeZones.lotusZones[97][0], "Pacific/Ponape", TimeZones.lotusZones[97][1]),
	PACIFIC_PORT_MORESBY(547, TimeZones.lotusZones[96][0], "Pacific/Port_Moresby", TimeZones.lotusZones[96][1]),
	PACIFIC_RAROTONGA(548, TimeZones.lotusZones[2][0], "Pacific/Rarotonga", TimeZones.lotusZones[2][1]),
	PACIFIC_SAIPAN(549, TimeZones.lotusZones[96][0], "Pacific/Saipan", TimeZones.lotusZones[96][1]),
	PACIFIC_SAMOA(550, TimeZones.lotusZones[104][0], "Pacific/Samoa", TimeZones.lotusZones[104][1]),
	PACIFIC_TAHITI(551, TimeZones.lotusZones[2][0], "Pacific/Tahiti", TimeZones.lotusZones[2][1]),
	PACIFIC_TARAWA(552, TimeZones.lotusZones[103][0], "Pacific/Tarawa", TimeZones.lotusZones[103][1]),
	PACIFIC_TONGATAPU(553, TimeZones.lotusZones[105][0], "Pacific/Tongatapu", TimeZones.lotusZones[105][1]),
	PACIFIC_TRUK(554, TimeZones.lotusZones[96][0], "Pacific/Truk", TimeZones.lotusZones[96][1]),
	PACIFIC_WAKE(555, TimeZones.lotusZones[103][0], "Pacific/Wake", TimeZones.lotusZones[103][1]),
	PACIFIC_WALLIS(556, TimeZones.lotusZones[103][0], "Pacific/Wallis", TimeZones.lotusZones[103][1]),
	PACIFIC_YAP(557, TimeZones.lotusZones[96][0], "Pacific/Yap", TimeZones.lotusZones[96][1]),
	POLAND(558, TimeZones.lotusZones[38][0], "Poland", TimeZones.lotusZones[38][1]),
	PORTUGAL(559, TimeZones.lotusZones[33][0], "Portugal", TimeZones.lotusZones[33][1]),
	PRC(560, TimeZones.lotusZones[80][0], "PRC", TimeZones.lotusZones[80][1]),
	PST8PDT(561, TimeZones.lotusZones[4][0], "PST8PDT", TimeZones.lotusZones[4][1]),
	ROC(562, TimeZones.lotusZones[83][0], "ROC", TimeZones.lotusZones[83][1]),
	ROK(563, TimeZones.lotusZones[86][0], "ROK", TimeZones.lotusZones[86][1]),
	SINGAPORE(564, TimeZones.lotusZones[82][0], "Singapore", TimeZones.lotusZones[82][1]),
	TURKEY(565, TimeZones.lotusZones[54][0], "Turkey", TimeZones.lotusZones[54][1]),
	UCT(566, TimeZones.lotusZones[34][0], "UCT", TimeZones.lotusZones[34][1]),
	UNIVERSAL(567, TimeZones.lotusZones[34][0], "Universal", TimeZones.lotusZones[34][1]),
	US_ALASKA(568, TimeZones.lotusZones[3][0], "US/Alaska", TimeZones.lotusZones[3][1]),
	US_ALEUTIAN(569, TimeZones.lotusZones[2][0], "US/Aleutian", TimeZones.lotusZones[2][1]),	// no equivalent
	US_ARIZONA(570, TimeZones.lotusZones[8][0], "US/Arizona", TimeZones.lotusZones[8][1]),
	US_CENTRAL(571, TimeZones.lotusZones[11][0], "US/Central", TimeZones.lotusZones[11][1]),
	US_EASTERN(572, TimeZones.lotusZones[13][0], "US/Eastern", TimeZones.lotusZones[13][1]),
	US_EAST_INDIANA(573, TimeZones.lotusZones[15][0], "US/East-Indiana", TimeZones.lotusZones[15][1]),
	US_HAWAII(574, TimeZones.lotusZones[2][0], "US/Hawaii", TimeZones.lotusZones[2][1]),
	US_INDIANA_STARKE(575, TimeZones.lotusZones[11][0], "US/Indiana-Starke", TimeZones.lotusZones[11][1]),
	US_MICHIGAN(576, TimeZones.lotusZones[13][0], "US/Michigan", TimeZones.lotusZones[13][1]),
	US_MOUNTAIN(577, TimeZones.lotusZones[6][0], "US/Mountain", TimeZones.lotusZones[6][1]),
	US_PACIFIC(578, TimeZones.lotusZones[4][0], "US/Pacific", TimeZones.lotusZones[4][1]),
	US_PACIFIC_NEW(579, TimeZones.lotusZones[4][0], "US/Pacific-New", TimeZones.lotusZones[4][1]),
	US_SAMOA(580, TimeZones.lotusZones[104][0], "US/Samoa", TimeZones.lotusZones[104][1]),
	UTC(581, TimeZones.lotusZones[34][0], "UTC", TimeZones.lotusZones[34][1]),
	WET(582, TimeZones.lotusZones[33][0], "WET", TimeZones.lotusZones[33][1]),
	W_SU(583, TimeZones.lotusZones[59][0], "W-SU", TimeZones.lotusZones[59][1]),
	ZULU(584, TimeZones.lotusZones[34][0], "Zulu", TimeZones.lotusZones[34][1]),
	;
	
	private int index;
	private String lotus, area, lotuslabel;
	private String[] shrt;
	private int[] offset, numday;

	private TimeZones(final int _index,  final String _lotus, final String _area,
			final String _lotuslabel) {
		index = _index;
		lotus = _lotus;
		area = _area;
		lotuslabel = _lotuslabel;
	}

	public int getIndex() {
		return index;
	}

	public String getLNName() {
		return lotus;
	}

	public String getLNLabel() {
		return lotuslabel;
	}

	public String getArea() {
		return area;
	}

	public String[] getShort() {
		return shrt;
	}

	public String getShort(int dayofyear) {
		if (shrt.length == 1)
			return shrt[0];
		int bottom = -1, idx = -1;
		for (int i = 0; i < shrt.length; i++) {
			if (numday[i] > bottom && dayofyear >= numday[i]) {
				bottom = numday[i];
				idx = i + 1;
			}
		}
		if (idx == shrt.length)
			return shrt[0];
		else
			return shrt[idx];
	}

	public int[] getOffset() {
		return offset;
	}

	public int getOffset(int dayofyear) {
		if (offset.length == 1)
			return offset[0];
		int bottom = -1, idx = -1;
		for (int i = 0; i < offset.length; i++) {
			if (numday[i] > bottom && dayofyear >= numday[i]) {
				bottom = numday[i];
				idx = i + 1;
			}
		}
		if (idx == offset.length)
			return offset[0];
		else
			return offset[idx];
	}

	public int[] getDSTSwitchDays() {
		return numday;
	}

	public static TimeZones get(final int _index) {
		for (TimeZones tz : TimeZones.values()) {
			if (tz.getIndex() == _index) return tz;
		}
		return null;
	}
	
	public static TimeZones getByArea(final String _area) {
		for (TimeZones tz : TimeZones.values()) {
			if (tz.getArea().equals(_area)) return tz;
		}
		return null;
	}

	/**
	 * Taken from Teamroom v.9.0.1 FP5 data.
	 */
	private static final String[][] lotusZones = new String[][] {
			{ "Z=12$DO=0$ZX=27$ZN=Dateline", "(GMT-12:00) International Date Line West" },	// 0
			{ "Z=11$DO=0$ZX=98$ZN=UTC-11", "(GMT-11:00) Coordinated Universal Time-11" },	// 1
			{ "Z=10$DO=0$ZX=42$ZN=Hawaiian", "(GMT-10:00) Hawaii" },	// 2
			{ "Z=9$DO=1$DL=3 2 1 11 1 1$ZX=1$ZN=Alaskan", "(GMT-09:00) Alaska" },	// 3
			{ "Z=8$DO=1$DL=3 2 1 11 1 1$ZX=69$ZN=Pacific", "(GMT-08:00) Pacific Time (US & Canada)" },	// 4
			{ "Z=8$DO=1$DL=4 1 1 10 -1 1$ZX=70$ZN=Pacific Standard Time (Mexico)", "(GMT-08:00) Baja California" },	// 5
			{ "Z=7$DO=1$DL=3 2 1 11 1 1$ZX=58$ZN=Mountain", "(GMT-07:00) Mountain Time (US & Canada)" },	// 6
			{ "Z=7$DO=1$DL=4 1 1 10 -1 1$ZX=59$ZN=Mountain Standard Time (Mexico)", "(GMT-07:00) Chihuahua, La Paz, Mazatlan" },	// 7
			{ "Z=7$DO=0$ZX=94$ZN=US Mountain", "(GMT-07:00) Arizona" },	// 8
			{ "Z=6$DO=0$ZX=14$ZN=Canada Central", "(GMT-06:00) Saskatchewan" },	// 9
			{ "Z=6$DO=0$ZX=18$ZN=Central America", "(GMT-06:00) Central America" },	// 10
			{ "Z=6$DO=1$DL=3 2 1 11 1 1$ZX=24$ZN=Central", "(GMT-06:00) Central Time (US & Canada)" },	// 11
			{ "Z=6$DO=1$DL=4 1 1 10 -1 1$ZX=25$ZN=Central Standard Time (Mexico)", "(GMT-06:00) Guadalajara, Mexico City, Monterrey" },	// 12
			{ "Z=5$DO=1$DL=3 2 1 11 1 1$ZX=32$ZN=Eastern", "(GMT-05:00) Eastern Time (US & Canada)" },	// 13
			{ "Z=5$DO=0$ZX=79$ZN=SA Pacific", "(GMT-05:00) Bogota, Lima, Quito" },	// 14
			{ "Z=5$DO=1$DL=3 2 1 11 1 1$ZX=93$ZN=US Eastern", "(GMT-05:00) Indiana (East)" },	// 15
			{ "Z=3004$DO=0$ZX=99$ZN=Venezuela", "(GMT-04:30) Caracas" },	// 16
			{ "Z=4$DO=1$DL=3 2 1 11 1 1$ZX=6$ZN=Atlantic", "(GMT-04:00) Atlantic Time (Canada)" },	// 17
			{ "Z=4$DO=1$DL=10 3 7 2 3 7$ZX=20$ZN=Central Brazilian", "(GMT-04:00) Cuiaba" },	// 18
			{ "Z=4$DO=1$DL=10 2 7 3 2 7$ZX=68$ZN=Pacific SA", "(GMT-04:00) Santiago" },	// 19
			{ "Z=4$DO=1$DL=10 1 7 3 3 7$ZX=72$ZN=Paraguay", "(GMT-04:00) Asuncion" },	// 20
			{ "Z=4$DO=0$ZX=80$ZN=SA Western", "(GMT-04:00) Georgetown, La Paz, Manaus, San Juan" },	// 21
			{ "Z=3003$DO=1$DL=3 2 1 11 1 1$ZX=65$ZN=Newfoundland", "(GMT-03:30) Newfoundland" },	// 22
			{ "Z=3$DO=0$ZX=5$ZN=Argentina", "(GMT-03:00) Buenos Aires" },	// 23
			{ "Z=3$DO=0$ZX=11$ZN=Bahia", "(GMT-03:00) Salvador" },	// 24
			{ "Z=3$DO=1$DL=10 3 7 2 3 7$ZX=31$ZN=E. South America", "(GMT-03:00) Brasilia" },	// 25
			{ "Z=3$DO=1$DL=3 -1 7 10 4 7$ZX=39$ZN=Greenland", "(GMT-03:00) Greenland" },	// 26
			{ "Z=3$DO=1$DL=10 1 1 3 2 1$ZX=56$ZN=Montevideo", "(GMT-03:00) Montevideo" },	// 27
			{ "Z=3$DO=0$ZX=78$ZN=SA Eastern", "(GMT-03:00) Cayenne, Fortaleza" },	// 28
			{ "Z=2$DO=1$DL=3 -1 1 9 -1 1$ZX=54$ZN=Mid-Atlantic", "(GMT-02:00) Mid-Atlantic - Old" },	// 29
			{ "Z=2$DO=0$ZX=97$ZN=UTC-02", "(GMT-02:00) Coordinated Universal Time-02" },	// 30
			{ "Z=1$DO=1$DL=3 -1 1 10 -1 1$ZX=10$ZN=Azores", "(GMT-01:00) Azores" },	// 31
			{ "Z=1$DO=0$ZX=15$ZN=Cape Verde", "(GMT-01:00) Cape Verde Is." },	// 32
			{ "Z=0$DO=1$DL=3 -1 1 10 -1 1$ZX=38$ZN=GMT", "(GMT) Greenwich Mean Time : Dublin, Edinburgh, Lisbon, London" },	// 33
			{ "Z=0$DO=0$ZX=40$ZN=Greenwich", "(GMT) Monrovia, Reykjavik" },	// 34
			{ "Z=0$DO=1$DL=3 -1 1 10 -1 1$ZX=57$ZN=Morocco", "(GMT) Casablanca" },	// 35
			{ "Z=0$DO=0$ZX=95$ZN=UTC", "(GMT) Coordinated Universal Time" },	// 36
			{ "Z=-1$DO=1$DL=3 -1 1 10 -1 1$ZX=21$ZN=Central Europe", "(GMT+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague" },	// 37
			{ "Z=-1$DO=1$DL=3 -1 1 10 -1 1$ZX=22$ZN=Central European", "(GMT+01:00) Sarajevo, Skopje, Warsaw, Zagreb" },	// 38
			{ "Z=-1$DO=1$DL=9 1 1 4 1 1$ZX=62$ZN=Namibia", "(GMT+01:00) Windhoek" },	// 39
			{ "Z=-1$DO=1$DL=3 -1 1 10 -1 1$ZX=73$ZN=Romance", "(GMT+01:00) Brussels, Copenhagen, Madrid, Paris" },	// 40
			{ "Z=-1$DO=0$ZX=102$ZN=W. Central Africa", "(GMT+01:00) West Central Africa" },	// 41
			{ "Z=-1$DO=1$DL=3 -1 1 10 -1 1$ZX=103$ZN=W. Europe", "(GMT+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna" },	// 42
			{ "Z=-2$DO=1$DL=3 -1 1 10 -1 1$ZX=30$ZN=E. Europe", "(GMT+02:00) E. Europe" },	// 43
			{ "Z=-2$DO=0$ZX=33$ZN=Egypt", "(GMT+02:00) Cairo" },	// 44
			{ "Z=-2$DO=1$DL=3 -1 1 10 -1 1$ZX=36$ZN=FLE", "(GMT+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius" },	// 45
			{ "Z=-2$DO=1$DL=3 -1 1 10 -1 1$ZX=41$ZN=GTB", "(GMT+02:00) Athens, Bucharest" },	// 46
			{ "Z=-2$DO=1$DL=3 -1 6 10 -1 1$ZX=45$ZN=Israel", "(GMT+02:00) Jerusalem" },	// 47
			{ "Z=-2$DO=1$DL=3 -1 5 10 -1 6$ZX=46$ZN=Jordan", "(GMT+02:00) Amman" },	// 48
			{ "Z=-2$DO=0$ZX=47$ZN=Kaliningrad", "(GMT+02:00) Kaliningrad (RTZ 1)" },	// 49
			{ "Z=-2$DO=0$ZX=50$ZN=Libya", "(GMT+02:00) Tripoli" },	// 50
			{ "Z=-2$DO=1$DL=3 -1 7 10 4 7$ZX=55$ZN=Middle East", "(GMT+02:00) Beirut" },	// 51
			{ "Z=-2$DO=0$ZX=84$ZN=South Africa", "(GMT+02:00) Harare, Pretoria" },	// 52
			{ "Z=-2$DO=1$DL=4 1 5 10 -1 5$ZX=86$ZN=Syria", "(GMT+02:00) Damascus" },	// 53
			{ "Z=-2$DO=1$DL=3 -1 1 10 -1 1$ZX=91$ZN=Turkey", "(GMT+02:00) Istanbul" },	// 54
			{ "Z=-3$DO=0$ZX=2$ZN=Arab", "(GMT+03:00) Kuwait, Riyadh" },	// 55
			{ "Z=-3$DO=0$ZX=4$ZN=Arabic", "(GMT+03:00) Baghdad" },	// 56
			{ "Z=-3$DO=0$ZX=13$ZN=Belarus", "(GMT+03:00) Minsk" },	// 57
			{ "Z=-3$DO=0$ZX=28$ZN=E. Africa", "(GMT+03:00) Nairobi" },	// 58
			{ "Z=-3$DO=0$ZX=77$ZN=Russian", "(GMT+03:00) Moscow, St. Petersburg, Volgograd (RTZ 2)" },	// 59
			{ "Z=-3003$DO=1$DL=3 3 7 9 3 2$ZX=44$ZN=Iran", "(GMT+03:30) Tehran" },	// 60
			{ "Z=-4$DO=0$ZX=3$ZN=Arabian", "(GMT+04:00) Abu Dhabi, Muscat" },	// 61
			{ "Z=-4$DO=1$DL=3 -1 1 10 -1 1$ZX=9$ZN=Azerbaijan", "(GMT+04:00) Baku" },	// 62
			{ "Z=-4$DO=0$ZX=16$ZN=Caucasus", "(GMT+04:00) Yerevan" },	// 63
			{ "Z=-4$DO=0$ZX=37$ZN=Georgian", "(GMT+04:00) Tbilisi" },	// 64
			{ "Z=-4$DO=0$ZX=53$ZN=Mauritius", "(GMT+04:00) Port Louis" },	// 65
			{ "Z=-4$DO=0$ZX=76$ZN=Russia Time Zone 3", "(GMT+04:00) Izhevsk, Samara (RTZ 3)" },	// 66
			{ "Z=-3004$DO=0$ZX=0$ZN=Afghanistan", "(GMT+04:30) Kabul" },	// 67
			{ "Z=-5$DO=0$ZX=34$ZN=Ekaterinburg", "(GMT+05:00) Ekaterinburg (RTZ 4)" },	// 68
			{ "Z=-5$DO=0$ZX=71$ZN=Pakistan", "(GMT+05:00) Islamabad, Karachi" },	// 69
			{ "Z=-5$DO=0$ZX=104$ZN=West Asia", "(GMT+05:00) Ashgabat, Tashkent" },	// 70
			{ "Z=-3005$DO=0$ZX=43$ZN=India", "(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi" },	// 71
			{ "Z=-3005$DO=0$ZX=85$ZN=Sri Lanka", "(GMT+05:30) Sri Jayawardenepura" },	// 72
			{ "Z=-4505$DO=0$ZX=63$ZN=Nepal", "(GMT+05:45) Kathmandu" },	// 73
			{ "Z=-6$DO=0$ZX=12$ZN=Bangladesh", "(GMT+06:00) Dhaka" },	// 74
			{ "Z=-6$DO=0$ZX=19$ZN=Central Asia", "(GMT+06:00) Astana" },	// 75
			{ "Z=-6$DO=0$ZX=61$ZN=N. Central Asia", "(GMT+06:00) Novosibirsk (RTZ 5)" },	// 76
			{ "Z=-3006$DO=0$ZX=60$ZN=Myanmar", "(GMT+06:30) Yangon (Rangoon)" },	// 77
			{ "Z=-7$DO=0$ZX=67$ZN=North Asia", "(GMT+07:00) Krasnoyarsk (RTZ 6)" },	// 78
			{ "Z=-7$DO=0$ZX=82$ZN=SE Asia", "(GMT+07:00) Bangkok, Hanoi, Jakarta" },	// 79
			{ "Z=-8$DO=0$ZX=26$ZN=China", "(GMT+08:00) Beijing, Chongqing, Hong Kong, Urumqi" },	// 80
			{ "Z=-8$DO=0$ZX=66$ZN=North Asia East", "(GMT+08:00) Irkutsk (RTZ 7)" },	// 81
			{ "Z=-8$DO=0$ZX=83$ZN=Singapore", "(GMT+08:00) Kuala Lumpur, Singapore" },	// 82
			{ "Z=-8$DO=0$ZX=87$ZN=Taipei", "(GMT+08:00) Taipei" },	// 83
			{ "Z=-8$DO=0$ZX=92$ZN=Ulaanbaatar", "(GMT+08:00) Ulaanbaatar" },	// 84
			{ "Z=-8$DO=0$ZX=101$ZN=W. Australia", "(GMT+08:00) Perth" },	// 85
			{ "Z=-9$DO=0$ZX=49$ZN=Korea", "(GMT+09:00) Seoul" },	// 86
			{ "Z=-9$DO=0$ZX=89$ZN=Tokyo", "(GMT+09:00) Osaka, Sapporo, Tokyo" },	// 87
			{ "Z=-9$DO=0$ZX=106$ZN=Yakutsk", "(GMT+09:00) Yakutsk (RTZ 8)" },	// 88
			{ "Z=-3009$DO=0$ZX=7$ZN=AUS Central", "(GMT+09:30) Darwin" },	// 89
			{ "Z=-3009$DO=1$DL=10 1 1 4 1 1$ZX=17$ZN=Cen. Australia", "(GMT+09:30) Adelaide" },	// 90
			{ "Z=-10$DO=1$DL=10 1 1 4 1 1$ZX=8$ZN=AUS Eastern", "(GMT+10:00) Canberra, Melbourne, Sydney" },	// 91
			{ "Z=-10$DO=0$ZX=29$ZN=E. Australia", "(GMT+10:00) Brisbane" },	// 92
			{ "Z=-10$DO=0$ZX=52$ZN=Magadan", "(GMT+10:00) Magadan" },	// 93
			{ "Z=-10$DO=1$DL=10 1 1 4 1 1$ZX=88$ZN=Tasmania", "(GMT+10:00) Hobart" },	// 94
			{ "Z=-10$DO=0$ZX=100$ZN=Vladivostok", "(GMT+10:00) Vladivostok, Magadan (RTZ 9)" },	// 95
			{ "Z=-10$DO=0$ZX=105$ZN=West Pacific", "(GMT+10:00) Guam, Port Moresby" },	// 96
			{ "Z=-11$DO=0$ZX=23$ZN=Central Pacific", "(GMT+11:00) Solomon Is., New Caledonia" },	// 97
			{ "Z=-11$DO=0$ZX=74$ZN=Russia Time Zone 10", "(GMT+11:00) Chokurdakh (RTZ 10)" },	// 98
			{ "Z=-12$DO=1$DL=10 4 1 1 3 1$ZX=35$ZN=Fiji", "(GMT+12:00) Fiji" },	// 99
			{ "Z=-12$DO=1$DL=3 -1 1 10 -1 1$ZX=48$ZN=Kamchatka", "(GMT+12:00) Petropavlovsk-Kamchatsky - Old" },	// 100
			{ "Z=-12$DO=1$DL=9 -1 1 4 1 1$ZX=64$ZN=New Zealand", "(GMT+12:00) Auckland, Wellington" },	// 101
			{ "Z=-12$DO=0$ZX=75$ZN=Russia Time Zone 11", "(GMT+12:00) Anadyr, Petropavlovsk-Kamchatsky (RTZ 11)" },	// 102
			{ "Z=-12$DO=0$ZX=96$ZN=UTC+12", "(GMT+12:00) Coordinated Universal Time+12" },	// 103
			{ "Z=-13$DO=1$DL=9 -1 1 4 1 1$ZX=81$ZN=Samoa", "(GMT+13:00) Samoa" },	// 104
			{ "Z=-13$DO=0$ZX=90$ZN=Tonga", "(GMT+13:00) Nuku'alofa" },	// 105
			{ "Z=-14$DO=0$ZX=51$ZN=Line Islands", "(GMT+14:00) Kiritimati Island" }	// 106
	};
}
