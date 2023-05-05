package fortuna.bettingsource.betfair;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.BettingExchange.BETFAIR_EXCHANGE;
import static fortuna.models.source.Bookmaker.BETFAIR;

@Builder
public class BetfairBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-premier-league/10932509")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-championship/7129730")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-fa-cup/30558")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-league-1/35")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-league-2/37")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-serie-a/81")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-serie-b/12199689")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-cup/12214429")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/uefa-champions-league/228")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/uefa-europa-league/2005")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/uefa-europa-conference-league/12375833")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/spanish-la-liga/117")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/spanish-segunda-division/12204313")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/spanish-copa-del-rey/12801")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/french-ligue-1/55")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/french-ligue-2/57")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/french-cup/12209560")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/german-bundesliga/59")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/german-bundesliga-2/61")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/german-cup/11458113")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/turkish-1-lig/175680")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/turkish-1-lig/175680")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                                /* PORTUGAL */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/portuguese-primeira-liga/99")
                                        .description("PRIMIERA_LIGA_PORTUGAL")
                                        .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/portuguese-segunda-liga/9513")
                                        .description("PRIMIERA_LIGA_PORTUGAL")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/portuguese-cup/12218844")
                                        .description("PRIMIERA_LIGA_PORTUGAL")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                            /* NETHERLANDS */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/dutch-eredivisie/9404054")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/dutch-eerste-divisie/11")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/dutch-cup/19513")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/austrian-bundesliga/10479956")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/austrian-erste-liga/9")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/austrian-cup/12204202")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/argentinian-primera-division/67387")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/argentinian-primera-b-nacional/803237")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/belgian-first-division-a/89979")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/belgian-cup/39770")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/austrian-bundesliga/10479956")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),

                                /* BRAZIL */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/brazilian-serie-a/13")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/brazilian-serie-b/321319")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/croatian-1-hnl/17")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/croatian-2-hnl/3992967")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CZECH REPUBLIC */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/czech-1-liga/12204204")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/czech-2-liga/862638")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),

                                /* DENMARK */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/danish-superliga/23")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/danish-1st-division/25")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/greek-super-league/67")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/greek-super-league-2/12267123")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                // TODO missing Ireland premier league
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/irish-division-1/12005855")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/israeli-premier-league/822165")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/japanese-j-league/89")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/japanese-j-league-2/1062024")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/japanese-j-league-3/4802285")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* NORWAY */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/norwegian-eliteserien/11068551")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/norwegian-1st-division/12209546")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/polish-ekstraklasa/97")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/polish-i-liga/403085")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/polish-cup/10854877")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/scottish-premiership/105")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/scottish-championship/107")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/scottish-league-one/109")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/scottish-league-two/111")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/scottish-fa-cup/12206708")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/swedish-allsvenskan/129")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/swedish-superettan/12202373")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/swedish-cup/18099")
                                        .eventCompetition(SWEDEN_CUP)
                                        .build(),

                                /* SWITZERLAND */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/swiss-super-league/133")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/swiss-challenge-league/135")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/swiss-1-liga-promotion/8964557")
                                        .eventCompetition(SWITZERLAND_PROMOTION_LEAGUE_3)
                                        .build(),

                                /* UKRAINE */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/ukrainian-premier-league/139")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* USA */
                                BetfairThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/sport/football/us-major-league-football/141")
                                        .eventCompetition(MLS)
                                        .build()
                        ).build();

    @Override
    public BettingSourceType getType() {
        return BETFAIR;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
