(ns hububba.views
  (:use hiccup.core))

(defn index [statuses]
  (html [:h1 "Hububba"]
        [:input {:name "status"}]
        [:div
         {:id "statuses"}
         [:ul
          (for [status statuses]
              [:li status])]]))
