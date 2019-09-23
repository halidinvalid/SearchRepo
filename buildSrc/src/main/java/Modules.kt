/*
 * App Modules
 */
object Modules {

    private const val BASE_DIRECTORY = ":base"
    private const val SHOW_ACCOUNTS = ":showAccounts"

    /*
     * App
     */
    const val app = ":app"

    /*
     * Base
     */
    const val core = "$BASE_DIRECTORY:core"
    const val corePresentation = "$BASE_DIRECTORY:core_presentation"
    const val coreDomain = "$BASE_DIRECTORY:core_domain"
    const val coreData = "$BASE_DIRECTORY:core_data"

    /*
     * Show accounts
     */
    const val showAccountsPresentation = "$SHOW_ACCOUNTS:show_accounts_presentation"
    const val showAccountsDomain = "$SHOW_ACCOUNTS:show_accounts_domain"
    const val showAccountsData = "$SHOW_ACCOUNTS:show_accounts_data"
}