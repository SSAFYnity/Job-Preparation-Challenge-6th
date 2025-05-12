# 250512
# 32924 KB / 316 ms
def main():
    # 정의
    # 소수 판별
    def find_prime_number():
        for i in range(3, 10000, 2):
            if i in prime_numbers:
                step = 2*i
                for j in range(3*i, 10000, step):
                    if j in prime_numbers:
                        prime_numbers.remove(j)

    # 골드바흐 파티션
    def find_partition(num):
        num1 = num2 = num // 2
        if num == 4:
            return '2 2'

        if num1 % 2 == 0:
            num1 -= 1
            num2 += 1

        while True:
            if num1 in prime_numbers and num2 in prime_numbers:
                return f'{num1} {num2}'

            num1 -= 2
            num2 += 2



    # 구현
    T = int(input())
    prime_numbers = set(range(3, 10000, 2))

    find_prime_number()
    prime_numbers.add(2)

    for _ in range(T):
        N = int(input())
        print(find_partition(N))

main()




# 34536 KB / 384 ms
def main():
    # 정의
    # 소수 판별
    def is_prime_number(num):
        from math import isqrt

        if num in prime_numbers:
            return True

        for i in range(3, isqrt(num)+1, 2):
            if num % i == 0:
                return False

        return True

    # 골드바흐 파티션
    def find_partition(num):
        num1 = num2 = num // 2
        if num == 4:
            return '2 2'

        if num1 % 2 == 0:
            num1 -= 1
            num2 += 1

        while True:
            if is_prime_number(num1) and is_prime_number(num2):
                return f'{num1} {num2}'

            num1 -= 2
            num2 += 2



    # 구현
    T = int(input())
    prime_numbers = {2}

    for _ in range(T):
        N = int(input())
        print(find_partition(N))

main()
