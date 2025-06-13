import decimal
decimal.getcontext().prec = 1000 # 소수점 이하 천자리까지 정확하게

T = int(input())
for _ in range(T):
    n = input()
    num = decimal.Decimal(n + '.0000000000')
    pow = decimal.Decimal('1') / decimal.Decimal('3')
    d = decimal.Decimal(num ** pow)
    d = round(d, 500)
    d = decimal.Decimal(d).quantize(decimal.Decimal('.0000000001'), rounding=decimal.ROUND_DOWN)
    print(d)