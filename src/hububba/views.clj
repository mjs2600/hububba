(ns hububba.views
  (:use hiccup.core
        hiccup.page
        hiccup.element))

(defn index [posts]
  (html (include-js "/js/goog/base.js" "/js/app.js")
        (javascript-tag "goog.require('hububba.core');")
        [:h1 "Hububba"]
        [:input {:name "post"}]
        [:textarea {:name "content"}]
        [:input {:type "button"
                 :value "Post"}]
        [:div
         {:id "posts"}
         [:ul
          (for [post posts]
            [:li (:title post)])]]))
