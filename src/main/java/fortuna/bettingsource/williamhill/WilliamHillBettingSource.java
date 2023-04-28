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
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY295/english-premier-league/matches/OB_MGMB/Match-Betting9")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY292/English-Championship/matches/OB_MGMB/Match-Betting")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY129/English-FA-Cup/matches/OB_MGMB/Match-Betting8")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY293/English-League-1/matches/OB_MGMB/Match-Betting")
                                    .description("LEAGUE_1")
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
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY1074/Turkish-Lig-1/matches/OB_MGMB/Match-Betting")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY331/Portuguese-Primeira-Liga/matches/OB_MGMB/Match-Betting")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
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
