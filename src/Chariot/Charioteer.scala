package Chariot

/**
 * @author 
 */

import robocode._
import robocode.util.Utils
import java.awt._
 
class Charioteer extends AdvancedRobot {
 
  // Main thread of robot
  override def run {
    setAdjustGunForRobotTurn(true)
    my_color(paint_color)
    
    while (true) {
      // If we're not going anywhere, move randomly around battlefield
      if (Math.abs(getDistanceRemaining) < Rules.MAX_VELOCITY
          && Math.abs(getTurnRemaining) < Rules.MAX_TURN_RATE)
      {
        setAhead((Math.random*3-1)*100)
        setTurnRight(Math.random*90-35)
      }
      // Tell RADAR to spin
      if (getRadarTurnRemaining == 0)
        setTurnRadarRightRadians(4)
      // Carry out pending actions
      execute
    }
  }
 
  // Picked up a robot on RADAR
  override def onScannedRobot(e : ScannedRobotEvent) {
    // Absolute bearing to detected robot
    val absBearing = e.getBearingRadians + getHeadingRadians
    var fire_rate = 2

    // Tell RADAR to paint detected robot
    setTurnRadarRightRadians(3*Utils.normalRelativeAngle(
      absBearing - getRadarHeadingRadians ))
 
    // Tell gun to point at detected robot
    setTurnGunRightRadians(Utils.normalRelativeAngle(
      absBearing - getGunHeadingRadians ))
 
    // Tell robot to shoot with power 2
    setFire(fire_rate)
  }
 
  // Robot ran into a wall
  override def  onHitWall(e : HitWallEvent) {
    // Turn in opposite direction to wall
    setTurnRightRadians(Utils.normalRelativeAngle(
      e.getBearingRadians + math.Pi))
  }
  
  val paint_color = new Color(189, 183, 107)
  
  def my_color(x:Color)={
     setBodyColor(x)
     setBulletColor(x)
     setGunColor(x)
     setRadarColor(x)
     setScanColor(x)
  }
  
  override def onHitByBullet(e : HitByBulletEvent) = {
    setAhead((Math.random*3-1)*100)
    setTurnRight(Math.random*90-30)
  }
  
  override def onWin(e : WinEvent) = {
    for (i <- 1 to 10){
      turnRight(30);
      turnLeft(30);
    }
  }
}