import { createI18n } from "vue-i18n";
import enMessages from "./en";
import frMessages from "./fr";

const shortDatetimeFormat = {
    year: "numeric", month: "numeric", day: "2-digit"
} //2-digit car short

const longDatetimeFormat = {
    year: "numeric", month: "long", day: "numeric"
}

const datetimeFormats = {
    'en': {
        short: shortDatetimeFormat,
        long: longDatetimeFormat
    },
    'fr': {
        short: shortDatetimeFormat,
        long: longDatetimeFormat
    }
}

const numberFormats = {
    'en': {
        currency: {
        style: 'currency', currency: 'USD', notation: 'standard'
        }
    },
    'fr': {
        currency: {
        style: 'currency', currency: 'EUR', notation: 'standard'
        }
    }
}//clé currency: monnaie ou clé nommée pourcent: pourcentage


//instanciation de i18n
//plugin i18n
const i18n = createI18n({
    locale: 'en',
    fallbackLocale: 'en',
    messages: {
        en: enMessages,
        fr: frMessages
    },
    datetimeFormats,
    numberFormats
})

export default i18n