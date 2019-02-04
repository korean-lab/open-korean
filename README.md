# open-korean
한국어 관련 모임, 행사, 관련 자료 그리고 오픈 소스나 해결 방법에 관한 정보를 공유하는 저장소입니다.

## 한국어 관련 프로그래밍 문제 해결 방법 ##

### [BasicKoreanLib](lib/BasicKoreanLib.java) ###

- 단어의 종성에 따라 '을/를', '이/가', '은/는' 등의 구분

```java
/*
buildEunJosa() : '은, 는'을 구분하기 위한 메소드.
buildGaJosa() : '이가, 가'를 구분하기 위한 메소드.
buildEulJosa() : '을, 를'을 구분하기 위한 메소드.
*/
String str = BasicKoreanLib.buildEunJosa("제 이름")+" Korean Lab이고 "+ BasicKoreanLib.buildEunJosa("나이") + " 19살입니다.";
System.out.println(str);
```

## 오픈 소스: ##

### 형태소 분석기 ###

- dha1
- dha2
- [khaiii](https://github.com/kakao/khaiii) - [블로그](https://brunch.co.kr/@kakao-it/308?fbclid=IwAR3IVt-5FKmt4-vygpQlJGQ6S2V0xbVPb-fsuNB0uIl29eGMXUZywMEgqFU)

#### [Korean Conjugation](https://github.com/dbravender/korean_conjugation) ####

- The mobile version of dongsa.net will run directly in modern browsers. Just
open up html/index.html in your browser.

### Voice ###

- [multi-speaker-tacotron-tensorflow](https://github.com/carpedm20/multi-speaker-tacotron-tensorflow)
- [](https://github.com/Kyubyong/kss)

## 모임/행사/학회 ##

### 기술 관련: ###

#### 1. [언어공학연구회](http://www.hclt.kr/symp/?lnb=conference)
##### 한글 및 한국어 정보처리 학술대회(매년 10월 중순) #####

### 한글 관련: ###

#### 1. [한글 학회](https://www.hangeul.or.kr/modules/doc/index.php?doc=intro) ####

##### - (구 조선어학회) #####

### 교육관련: ###

#### 1. [이중언어학회](http://www.korbiling.org/langhak/user/class) ####

#### 2. [국제한국어교육학회](http://www.iakle.com) ####
