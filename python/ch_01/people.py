# person 객체를 하나 만들고
# 생성자에 이름과 나이, 주소를 받을 수 있도록 생성자를 정의하고
# 함수로 자신의 이름가 함께 '안녕하세요 저는 한다희 입니다.' 출력함수 있는 함수를 만드세요.

class person:
    def __init__(self, p_name, age, address):
        self.p_name=p_name
        self.age=age
        self.address=address

    def print_info(self):
        print(f'안녕하세요 저는 {self.p_name}입니다.')
