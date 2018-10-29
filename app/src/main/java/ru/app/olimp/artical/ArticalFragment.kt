package ru.app.olimp.artical

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_article.*
import ru.app.olimp.R

class ArticalFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
    }

    private fun setText() {
        text.text = Html.fromHtml("Every year there are more and more ways to earn money online. But, despite this diversity, the majority of people still cannot start earning income on the internet. Why? The fact is that almost all ways to make money on the internet require significant personal investments: spending on advertising, or buying goods, if with internet stores, etc.\n" +
                "    <br>Nevertheless, there are ways to earn money online with minimum or no investments. Trading, for example, namely binary options trading. It is far simpler than trading on the classic financial markets, but you can earn income comparable with that generated on the currency and stock exchanges.<br>" +
                "<br>" +
                "        There is, however, one problem that many novices face – they have a fairly hard time choosing a broker. We decided to help all beginning traders and to talk about one of the most popular and fastest growing binary options brokers – <a href=\"https://olymptrade.com/?traffic=1&amp;ref=pr_bizcommunity\">Olymp Trade.</a><br>" +
                "<br>" +
                "<b>Olymp Trade: up to 90% profit with minimum investments</b><br>" +
                "<br>" +
                "To start trading binary options with this broker, all you will need is \$10/€10 – this is the minimum deposit on the Olymp Trade platform. The minimum trade is \$1/€1, while your profit might be up to 80% of your investment on a regular account and up to 90%on a VIP account.<br>" +
                "<br>" +
                "The process of closing trades is as simple as could be, so even beginning traders will be able to learn to trade binary options fairly quickly. All you need to do is:<br>" +
                "choose an asset and indicate the trade amount and expiration – the time at which the trade will close;<br>" +
                "predict whether the price of that asset will rise or fall over the specified time period.<br>" +
                "There are more than 60 assets on the Olymp Trade platform: currency pairs and crypto currencies, commodities, indexes, and stocks. You can choose any and set any trade time from 1 minute to 23 hours.<br>" +
                "<br>" +
                "Another nice bonus from Olymp Trade – there is no commission for depositing and withdrawing money. By the way, withdrawal takes an average of 1 day for regular account holders and just a few hours for VIP traders. The withdrawal methods are the same for everyone: bank cards or the Epayments, Webmoney, Neteller, or Bitcoin e-wallets.<br>" +
                "<br>" +
                "In just a minute therefore, you can make, say, \$9 net profit on a \$10 investment and withdraw it to card or e-wallet with nothing deducted by the broker.<br>" +
                "<br>" +
                "<b>I don’t know how to trade binary options, but I want to learn. Does Olymp Trade provide this opportunity?</b><br>" +
                "<br>" +
                "The broker discusses trading binary options in analytical articles especially for novices. You can take advantage of all these materials absolutely free at the Olymp Trade official Facebook page.<br>" +
                "<br>" +
                "The Olymp Trade platform also has a demo account, where you will be able to put the knowledge you acquire into practice. Access to this account and to all educational materials is provided to all traders at no cost.<br>" +
                "<br>" +
                "<b>Can I earn money at Olymp Trade without any investment?</b><br>" +
                "<br>" +
                "Yes, you can, through the Olymp Trade affiliate program. All you need to do is to recruit affiliates, and no investments are required. By the way, in April 2017, Olymp Trade Affiliate was recognized as the best affiliate program at the CPA Life conference. It earned such a high rating because of a number of features:<br>" +
                "the fastest payout of compensation (in this segment);<br>" +
                "effective affiliate motivation through contests with valuable prizes and gifts;<br>" +
                "professional technical and informational support for affiliates.<br>" +
                "At that same conference <a href=\"https://www.investing.com/brokers/olymptrade/press-releases/olymp-trade-has-won-four-awards-as-leading-binary-options-broker-200203834\">Olymp Trade</a> also won the category “Best Financial Broker,” and in 2016 was named the “Fastest-Growing Broker of the Year” at ShowFx World and the “Best Platform for Trading Binary Options” from IAIR Awards.<br>" +
                "<br>" +
                "<b>Does Olymp Trade have a support team?</b><br>" +
                "<br>" +
                "        Yes, and you can contact tech support specialists by the email (support-en@olymptrade.com), or via online chat at the broker’s site, or on the official <a href=\"https://www.facebook.com/olymptradecom/\">Olymp Trade Facebook page.</a><br>" +
                "<br>" +
                "Olymp Trade is a reliable, solid binary options broker that guarantees prompt payouts. You can make money with Olymp Trade even without investments. That is why more and more traders from South Africa prefer Olymp Trade when they choose a binary options broker.")
        text.movementMethod = LinkMovementMethod.getInstance()
    }
}
