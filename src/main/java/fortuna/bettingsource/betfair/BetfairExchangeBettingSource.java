package fortuna.bettingsource.betfair;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.BettingExchange.BETFAIR_EXCHANGE;

@Builder
public class BetfairExchangeBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/english-premier-league-betting-10932509")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/english-championship-betting-7129730")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/english-fa-cup-betting-30558")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/english-league-1-betting-35")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/english-league-2-betting-37")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/italian-serie-a-betting-81")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/italian-serie-b-betting-12199689")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            // TODO missing italy cup

                            /* EUROPE */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/uefa-champions-league-betting-228")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/uefa-europa-league-betting-2005")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/uefa-europa-conference-league-betting-12375833")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/spanish-la-liga-betting-117")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/spanish-segunda-division-betting-12204313")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/spanish-copa-del-rey-betting-12801")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/french-ligue-1-betting-55")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/french-ligue-2-betting-57")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            // TODO missing france cup

                            /* GERMANY */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/german-bundesliga-betting-59")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/german-bundesliga-2-betting-61")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            // TODO missing germany cup

                            /* TURKEY */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/turkish-super-league-betting-194215")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                // TODO missing Turkey cup

                                /* PORTUGAL */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/portuguese-primeira-liga-betting-99")
                                        .description("PRIMIERA_LIGA_PORTUGAL")
                                        .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/portuguese-segunda-liga-betting-9513")
                                        .description("PRIMIERA_LIGA_PORTUGAL")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                // TODO missing Portugal cup

                            /* NETHERLANDS */
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/dutch-eredivisie-betting-9404054")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetfairExchangeThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/exchange/plus/en/football/dutch-eerste-divisie-betting-11")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            // TODO missing dutch cup

                                /* AUSTRIA */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/austrian-bundesliga-betting-10479956")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/austrian-erste-liga-betting-99")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                // TODO missing austria cup

                                /* ARGENTINA */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/argentinian-primera-division-betting-67387")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/argentinian-primera-b-nacional-betting-803237")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/belgian-first-division-a-betting-89979")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/belgian-first-division-b-betting-11717188")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/bulgarian-a-league-betting-15")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),

                                /* BRAZIL */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/brazilian-serie-a-betting-13")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/brazilian-serie-b-betting-321319")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/croatian-1-hnl-betting-17")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/croatian-2-hnl-betting-3992967")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CZECH REPUBLIC */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/czech-1-liga-betting-12204204")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/czech-2-liga-betting-862638")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),

                                /* DENMARK */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/danish-superliga-betting-23")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/danish-1st-division-betting-25")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/greek-super-league-betting-67")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/greek-super-league-2-betting-12267123")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/irish-premier-division-betting-12203971")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/irish-division-1-betting-12005855")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/israeli-premier-league-betting-822165")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/japanese-j-league-betting-89")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/japanese-j-league-2-betting-1062024")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                // TODO missing Japan league 3

                                /* NORWAY */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/norwegian-eliteserien-betting-11068551")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/norwegian-1st-division-betting-12209546")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/polish-ekstraklasa-betting-97")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/polish-i-liga-betting-403085")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                // TODO missing poland cup

                                /* SCOTLAND */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/scottish-premiership-betting-105")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/scottish-championship-betting-107")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/scottish-league-one-betting-109")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/scottish-league-two-betting-111")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                // TODO missing scotland cup

                                /* SWEDEN */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/swedish-allsvenskan-betting-129")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/swedish-superettan-betting-12202373")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing sweden cup

                                /* SWITZERLAND */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/swiss-super-league-betting-133")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/swiss-challenge-league-betting-135")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland league 3

                                /* UKRAINE */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/ukrainian-premier-league-betting-139")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* USA */
                                BetfairExchangeThreeWayBetOfferSource.builder()
                                        .url("https://www.betfair.com/exchange/plus/en/football/us-major-league-football-betting-141")
                                        .eventCompetition(MLS)
                                        .build()
                        ).build();

    @Override
    public BettingSourceType getType() {
        return BETFAIR_EXCHANGE;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
