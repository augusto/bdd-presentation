Description: show how parametrised scenarios work in JBehave

Scenario: Use a parametrised scenario
Given I have <accountCurrency> <initialBalance> in my account
When I withdraw <withdrawCurrency> <withdrawAmount>
Then my account balance is <accountCurrency> <finalBalance>

Examples:
| accountCurrency |initialBalance   |withdrawCurrency |withdrawAmount|finalBalance  |
| GBP             |1000             |GBP              |100           |900           |
| GBP             |1000             |EUR              |100           |921           |
| GBP             |1000             |USD              |100           |937           |

