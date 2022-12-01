/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.schedulingtasks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        log.info("The time is now{}", dataFormat.format(new Date()));
    }
}

/*
loggerFactory
https://waman.hatenablog.com/entry/20070826/1188153571

SimpleDateFormat
https://magazine.techacademy.jp/magazine/18611
パターン文字:意味
  G :紀元
  y :年
  M :年における月
  E :曜日の名前
  H :一日における時(0 - 23)
  h :午前または午後の時(1 - 12)
  m :分
  s :秒

@Scheduled
https://reasonable-code.com/spring-boot-scheduling-tasks/
パラメータ
fixedDelay：メソッドの前回の実行完了時刻から何ミリ秒後に実行するか。
fixedRate：メソッドの前回の実行開始時刻から何ミリ秒後に実行するか。
initialDelay：メソッドの初回実行時の待機時間。単位はミリ秒。
cron：cronによるスケジュール設定。zoneによるタイムゾーンの指定も可能。
*/
