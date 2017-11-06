(ns fuja.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(inc 3)

((hash-map :a 10, :b 20, :c 30) :b)

(:b {:a 10, :b 20, :c 30})

(conj {:a 1} [:b 2] {:c 3} [:d 4] )

(rest [10 20 30 40])

(= [20 30 40] (rest [10 20 30 40]))
(+ 1 20)
(= 6 6)

((fn add-five [x] (+ x 5)) 3)

((partial + 5) 3)

((fn [x](* x 2)) 4)
((fn [x](* x 3)) 6)
((fn [x](* x 11)) 22)
((fn [x](* x 7)) 14)

(#(* % 3) 6)
(#(* % 11) 22)
(#(* % 7) 14)
(#(* 2 %) 2)

((fn [x] (* 2 x)) 10)

(#(str "Hello, " %"!") "Dave")

(= (#(str "Hello, " %"!") "Dave") "Hello, Dave!")

(map #(* % 2) '[4 10])
(map #(+ % 5) '(1 2 3))
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))
(map #(> % 5) '(1 2 3 4 5 6 7 8))
(= (#(apply hash-map (interleave %2 (repeat %1))) 1 [:a :b :c]) {:a 1 :b 1 :c 1})

;; filter :
(filter #(> % 5) '(1 2 3 4 5 6 7 8))
(filter #(>= % 5) '(1 2 3 4 5 6 7 8))
(filter #(< % 5) '(1 2 3 4 5 6 7 8))
;; end of filter

;; reduce :
(reduce - [1 2 3 4 5])
(reduce + [1 2 3 4 5])
;; end of reduce

;; let
(let [x 7, y 3 , z 1] (+ x y))
(let [x 7, y 3 , z 1] (+ y z))
(let [x 7, y 3 , z 1] z)
(let [[a b c d e] [0 1 2 3 4]] [c e])
;; end of let



(
  (fn foo [x]
    (when (> x 0)
      (conj (foo (dec x)) x)
    )
  )
15)

(last (sort (rest (reverse [2 5 4 1 3 6]))))
(-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))

(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
   5)

  (loop [x 5
         result []]
    (if (> x 0)
      (conj result (+ 2 x))
      result))

(drop 2 [2 5 4 1 3 6])
(reverse (drop 2 [2 5 4 1 3 6]))
(drop 2 (reverse [2 5 4 1 3 6]))

(take 3 (drop 2 [2 5 4 1 3 6]))
(reduce + (take 3 (drop 2 [2 5 4 1 3 6])))
(map inc (take 3 (drop 2 [2 5 4 1 3 6])))

(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
   11)

(:c {:a nil :b 2})

((fn [k m] (if (contains? m k) (= (m k) nil) false)) :c {:a nil :b 2})
((fn [k m] (if (contains? m k) (= (m k) nil) false)) :a {:a nil :b 2})
(true? ((fn [k m] (if (contains? m k) (= (m k) nil) false)) :c {:a nil :b 2}))

(let [x 3, y 10])
(let [x 5] (+ 2 x))
(let [x 3, y 10] (- y x))
(let [x 21] (let [y 3] (/ x y)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

(map #(* % 2) (list 1 2 3 4 5))
(map #(* % 2) [1 2 3 4 5])
(#(nth %(dec(count %))) [1 2 3 4 5])

((comp) (list 1 2 3 4 4 3 2))
((comp second) (list 1 2 3 4 4 3 2))
((comp second reverse) (list 1 2 3 4 4 3 2))
((comp reverse) [1 2 3 4 5])

(apply str (re-seq #"[a-z]+" "bA1B3Ce "))
(apply str (re-seq #"[a-zA-Z]+" "bA1B3Ce "))

(#(reduce conj () %) [1 2 3 4 5])
(#(reduce conj () %) [1 2 3 4 5])
(= (#(reduce conj () %) [1 2 3 4 5]) [5 4 3 2 1])

(for [x (range 40)
      :when (= 1 (rem x 4))]
x)

(for [x (iterate #(+ 4 %) 1)
      :let [z (inc x)]
      :while (< z 40)]
z)

(for [x (iterate #(+ 4 %) 0)
      :let [z (inc x)]
      :while (< z 40)]
z)

;; nth element
(nth [:a :b :c] 0)
(nth '([1 2] [3 4] [5 6]) 2)
(= (nth [:a :b :c] 0) :a)
(= (nth [1 2 3 4] 2) 2)
(= (nth '([1 2] [3 4] [5 6]) 2) [5 6])
;; end of nth element

(range 40)
(partition 2 (range 11))

(for [[x y] (partition 2 (range 20))]
      (+ x y))

(if-not false 1 0)
(if 0 "dsadfdsafds" 1)
