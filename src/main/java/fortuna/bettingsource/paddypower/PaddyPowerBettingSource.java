package fortuna.bettingsource.paddypower;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.PADDY_POWER;

@Builder
public class PaddyPowerBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/english-premier-league")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/english-fa-cup")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/english-championship")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/english-league-1")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/english-league-2")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/italian-serie-a")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/italian-serie-b")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/italian-cup")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/uefa-champions-league")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/uefa-europa-league")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/uefa-europa-conference-league")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/spanish-la-liga")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/spanish-segunda-division")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/spanish-copa-del-rey")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/french-ligue-1")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/french-ligue-2")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/french-cup")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/german-bundesliga")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/german-bundesliga-2")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/german-cup")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/turkish-1-lig")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/turkish-1-lig")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                            /* PORTUGAL */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/portuguese-primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/portuguese-segunda-liga")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/portuguese-cup")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                            /* NETHERLANDS */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/dutch-eredivisie")
                                        .eventCompetition(EVERDISIE)
                                        .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/dutch-eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/dutch-cup")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/austrian-bundesliga")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/austrian-erste-liga")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/austrian-cup")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/argentinian-primera-division")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/argentinian-primera-b-nacional")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/belgian-first-division-a")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                // TODO missing belgium league 2
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/belgian-cup")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/bulgarian-a-league")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                // TODO missing bulgaria league 2

                                /* BRAZIL */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/brazilian-serie-a")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/brazilian-serie-b")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/croatian-1-hnl")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/croatian-2-hnl")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CYPRUS */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/cypriot-1st-division")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/czech-1-liga")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/czech-2-liga")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech republic cup

                                /* DENMARK */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/danish-superliga")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/danish-1st-division")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/greek-super-league")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/greek-super-league-2")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/irish-premier-division")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/irish-division-1")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/israeli-premier-league")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/japanese-j-league")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/japanese-j-league-2")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/japanese-j-league-3")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* MALTA */
                                // TODO missing malta cup

                                /* NORWAY */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/norwegian-eliteserien")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/norwegian-1st-division")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/polish-ekstraklasa")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/polish-i-liga")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/polish-cup")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/scottish-premiership")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/scottish-championship")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                // TODO missing scottish league 1 and 2
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/scottish-fa-cup")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/swedish-allsvenskan")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/swedish-superettan")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/swedish-cup")
                                        .eventCompetition(SWEDEN_CUP)
                                        .build(),

                                /* SWITZERLAND */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/swiss-super-league")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/swiss-challenge-league")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland league 3

                                /* UKRAINE */
                                // TODO missing ukraine league 1

                                /* USA */
                                PaddyPowerThreeWayBetOfferSource.builder()
                                        .url("https://www.paddypower.com/football/us-major-league-football")
                                        .eventCompetition(MLS)
                                        .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return PADDY_POWER;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
