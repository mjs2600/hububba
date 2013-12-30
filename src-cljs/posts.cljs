(ns hububba.posts
  (:require [ajax.core :refer [ajax-request
                               raw-response-format
                               url-request-format
                               codec]]
            [hububba.views :as views]))

(defn render-posts [[ok content]]
  (.log js/console content)
  (views/add-posts (cljs.reader/read-string (str content))))

(defn all-posts []
  (.log js/console "Getting posts")
  (ajax-request "/posts" :get {:handler render-posts
                               :format (codec (url-request-format)
                                              (raw-response-format))}))
