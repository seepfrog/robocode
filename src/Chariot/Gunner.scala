package Chariot

import robocode._
import robocode.util.Utils
import java.awt._

trait Gunner extends AdvancedRobot {
    private var fire_time:Long = 0
    private var power:Doble = 2

    def reserved_fire() = if(getTime == fire_time) fire(power)

    /**
     * 指定した場所に砲を向ける
     * @param point 位置ベクトル
     */
    def targetAt(point:Vector2) = {
      val direction = point - Vector2(getX,getY)
      setTurnGunRightRadians(Utils.normalRelativeAngle(direction.angle - getGunHeadingRadians))
    }

    def targetAt(x:Double, y:Double):Unit = targetAt(Vector2(x,y))

    /** ラフな線形予測射撃を行う
    def roughLinerPrediction(target:Enemy, power:Double) = {
      targetAt(target.position + target.velocity * (target.position - Vector2(getX,getY)).magnitude / (20 - 3 * power))
      fireTime = getTime + 1
      this.power = power
    }*/

    def prediction_fire(target1:Enemy ,target2:Enemy, power:Double) = {
      var enemy_acceleration
      var
    }
}
