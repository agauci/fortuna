package fortuna.bettingsource.williamhill;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.WILLIAM_HILL;

@Builder
public class WilliamHillBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY295/english-premier-league/matches/OB_MGMB/Match-Betting")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY292/English-Championship/matches/OB_MGMB/Match-Betting")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY129/English-FA-Cup/matches/OB_MGMB/Match-Betting")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY293/English-League-1/matches/OB_MGMB/Match-Betting")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY294/English-League-2/matches/OB_MGMB/Match-Betting")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY321/Italian-Serie-A/matches/OB_MGMB/Match-Betting")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY23532/Italian-Serie-B/matches/OB_MGMB/Match-Betting")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY181/Coppa-Italia/matches/OB_MGMB/Match-Betting")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY344/UEFA-Champions-League/matches/OB_MGMB/Match-Betting")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY1935/UEFA-Europa-League/matches/OB_MGMB/Match-Betting")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY47778/UEFA-Europa-Conference-League/matches/OB_MGMB/Match-Betting")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY338/Spanish-La-Liga-Primera/matches/OB_MGMB/Match-Betting")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY32982/Spanish-Segunda/matches/OB_MGMB/Match-Betting")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY652/Spanish-Copa-del-Rey/matches/OB_MGMB/Match-Betting")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY312/French-Ligue-1/matches/OB_MGMB/Match-Betting")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY314/French-Ligue-2/matches/OB_MGMB/Match-Betting")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY301/Coupe-de-France/matches/OB_MGMB/Match-Betting")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY315/German-Bundesliga/matches/OB_MGMB/Match-Betting")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY317/German-Bundesliga-2/matches/OB_MGMB/Match-Betting")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY316/DFB-Cup/matches/OB_MGMB/Match-Betting")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY325/Turkish-Super-Lig/matches/OB_MGMB/Match-Betting")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY1074/Turkish-Lig-1/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                            /* PORTUGAL */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY331/Portuguese-Primeira-Liga/matches/OB_MGMB/Match-Betting")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY332/Portuguese-Liga2/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY654/Taca-de-Portugal/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                            /* NETHERLANDS */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY306/Dutch-Eredivisie/matches/OB_MGMB/Match-Betting")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY1073/Dutch-Eerste-Divisie/matches/OB_MGMB/Match-Betting")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY307/Dutch-KNVB-Cup/matches/OB_MGMB/Match-Betting")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY179/Austrian-Bundesliga/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY35657/Austrian-2-Liga/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY655/Austrian-Cup/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY32135/Argentinian-Primera-Liga-Profesional/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY3252/Argentinian-Primera-Nacional/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY28159/Belgian-1st-Division-A/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY3798/Belgian-First-Division-B/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY653/Belgian-Cup/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY26259/Bulgarian-First-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                // TODO missing bulgaria league 2

                                /* BRAZIL */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY25743/Brazilian-Serie-A/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY1713/Brazilian-Serie-B/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY302/Croatian-1HNL/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                // TODO missing croatian league 2

                                /* CYPRUS */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY2859/Cypriot-Division-1/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY26740/Czech-First-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY32803/Czech-FNL/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech republic cup

                                /* DENMARK */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY25893/Danish-Super-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY27505/Danish-1st-Division/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY318/Greek-Super-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                // TODO missing greek league 2

                                /* IRELAND */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY308/Ireland-Premier-Division/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY309/Ireland-First-Division/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                // TODO missing israel league 1

                                /* JAPAN */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY3320/Japanese-J-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY5059/Japanese-J-League-2/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY3952/Japanese-J-League-3/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* MALTA */
                                // TODO missing malta cup

                                /* NORWAY */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY9428/Norwegian-Eliteserien/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY329/Norwegian-OBOS-Ligaen/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY330/Polish-Ekstraklasa/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY1467/Polish-1-Liga/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY910/Polish-FA-Cup/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY297/Scottish-Premiership/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY2/Scottish-Championship/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY298/Scottish-League-One/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY9692/Scottish-League-Two/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                // TODO missing scottish cup

                                /* SWEDEN */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY340/Swedish-Allsvenskan/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY341/Swedish-Superettan/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing swedish cup

                                /* SWITZERLAND */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY342/Swiss-Super-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY343/Swiss-Challenge-League/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland league 3

                                /* UKRAINE */
                                // TODO missing ukraine league 1

                                /* USA */
                                WilliamHillThreeWayBetOfferSource.builder()
                                        .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY353/US-Major-League-Soccer/matches/OB_MGMB/Match-Betting")
                                        .eventCompetition(MLS)
                                        .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return WILLIAM_HILL;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
