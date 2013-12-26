(ns hububba.views
  (:use hiccup.core))

(defn index [posts]
  (html [:h1 "Hububba"]
        [:input {:name "post"}]
        [:textarea {:name "content"}]
        [:input {:type "button"
                 :value "Post"}]
        [:div
         {:id "posts"}
         [:ul
          (for [post posts]
            [:li (:title post)])]]))
