'symbol ;symbol
'foo&bar ; this is also a symbol

:keyword ; keyword

(list 1 2 3 "4") ;list, single linked list
; list is a function

'(1 2 3) ; this is a list too
; quote means do not evaluate first statement
; skip evaluating part

[1 2 3] ; vector

{:fo 1, 'bo 2} ;hashmap
; key fo value 1
; key bo (symbol) value 2
; comma is treated as whitespace
; so it doesn't matter where to put the comma

(+ 1 2) ; + is a function, arg 1 2
; it is prefix notation
; (+ 1 2 3 4 5 6) is also work

#(+ % 5) ; this is a function literal
; this is will add 5 to given param
; example :
(#(+ % 5) 3) ; this will add 3 to 5

(if true :true :false) ; conditionals
; if true return :true
; else return :false

(range 1 5) ; start from 1 to 4

(inc 7) ; increment 7 to 1

(map inc (range 5)) ; inc range 0-4
(filter even? (range 10))

(let
  [a 1 b 2]
  (+ a b)) ; let let you bind value to names
; and use names in the body of the code
; bind 1 to a, bind 2 to b
; a and b only can be accessed in body let
; another example
(let [square #(* % %)
      nonenegative (range)
      squares (map square nonenegative)
      odd-squares (filter odd? squares)
      first-10 (take 10 odd-squares)
      sum (reduce + 0 first-10)]
      sum)

(->> (range)
  (map #(* % %))
  (filter odd?)
  (take 10)
  (reduce + 0))
; ->> is threading operator taking result from range and slide it in the last of next function, and so on
; so range -> list range => result
; (map func result)
; (filter odd? result)
; (take 10 result)
; (reduce + 10 result)

(def v [1 2 3]) ; define v as vector
(def square #(* % %))
(square 5)
; above is sugar syntax from code below
(def square (fn [x] (* x x)))
(square 5)
; def and fn can be shortened with defn
(defn square [x] (* x x))
(square 5)


; immutability
(def w (conj v 4)) ; assign w v + 4, v still the same
(def hm {:foo 1, :bar 2}) ; define new hash map
(def new_hm (assoc hm :baz 3)) ; return new hash map with new key
(update hm :foo #(+ % %)) ; update key hashmap by run function on right side argumen which is literal function

(map hm [:foo :bar]) ; data structure as function
; it will give value from hashmasp with given key
(:foo hm) ; it will return value from key :foo
(let
  [
    jeff {:name "jeff", :age 37, :adult? true}
    jane {:name "Jane", :age 4, :adult? false}
    people [jeff jane]
  ]

  (map :name people)
  (filter :adult? people)
)

