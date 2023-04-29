package fortuna.bettingsource.ejjabet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.IZIBET;

@Builder
public class EjjabetBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22057336&region=2570001&competition=538&sport=1")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=1840&sport=1")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=539&sport=1")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=1843&sport=1")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=1844&sport=1")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=543&sport=1&region=1170001")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=544&sport=1&region=1170001")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=572&sport=1&region=1170001")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=566&sport=1&region=20001")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1861&sport=1&region=20001")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=18278410&sport=1&region=20001")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=545&sport=1&region=2150001")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=553&sport=1&region=2150001")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=2991&sport=1&region=2150001")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=548&sport=1&region=830001")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=549&sport=1&region=830001")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1871&sport=1&region=830001")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=541&sport=1&region=900001")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=542&sport=1&region=900001")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1876&sport=1&region=900001")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=3013&sport=1&region=2340001")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&region=2340001&competition=3014&sport=1")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                            /* PORTUGAL */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=560&sport=1&region=1850001")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=561&sport=1&region=1850001")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),

                            /* NETHERLANDS */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1957&sport=1&region=1640001")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1958&sport=1&region=1640001")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1959&sport=1&region=1640001")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=556&sport=1&region=220001")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1707&sport=1&region=220001")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1708&sport=1&region=220001")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1685&sport=1&region=180001")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1684&sport=1&region=180001")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=557&sport=1&region=290001")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                // TODO missing belgian league 2
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1788&sport=1&region=290001")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1805&sport=1&region=420001")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                // TODO missing bulgaria league 2

                                /* BRAZIL */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1792&sport=1&region=390001")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3104&sport=1&region=390001")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1822&sport=1&region=630001")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                // TODO missing croatia league 2

                                /* CYPRUS */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1825&sport=1&region=660001")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1826&sport=1&region=670001")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1829&sport=1&region=670001")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech republic cup

                                /* DENMARK */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1833&sport=1&region=680001")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1830&sport=1&region=680001")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1884&sport=1&region=930001")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=27887&sport=1&region=930001")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1985&sport=1&region=1140001")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1986&sport=1&region=1140001")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1908&sport=1&region=1160001")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1922&sport=1&region=1190001")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1923&sport=1&region=1190001")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=10834&sport=1&region=1190001")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* MALTA */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1950&sport=1&region=1450001")
                                        .eventCompetition(MALTA_CUP)
                                        .build(),

                                /* NORWAY */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=562&sport=1&region=1730001")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1967&sport=1&region=1730001")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1978&sport=1&region=1840001")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1979&sport=1&region=1840001")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=1977&sport=1&region=1840001")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=555&sport=1&region=2590001")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=552&sport=1&region=2590001")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                // TODO missing scottish league 1 and 2
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=2973&sport=1&region=2590001")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3000&sport=1&region=2210001")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3003&sport=1&region=2210001")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing sweden cup

                                /* SWITZERLAND */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3007&sport=1&region=2220001")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3006&sport=1&region=2220001")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland league 3

                                /* UKRAINE */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3020&sport=1&region=2390001")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* USA */
                                EjjabetThreeWayBetOfferSource.builder()
                                        .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101279&competition=3025&sport=1&region=2420001")
                                        .eventCompetition(MLS)
                                        .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return IZIBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
