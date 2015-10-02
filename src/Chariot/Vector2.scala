package Chariot

/**
 * @author Haretaro
 * robocode�p�̃x�N�g���N���X
 */
case class Vector2 (val x:Double, val y:Double){
  
  /** @return �p�x(���W�A��) */
  def angle = math.atan2(-y,x) + math.Pi/2
  
  /** @return �p�x(�x) */
  def angleDegrees = math.toDegrees(angle)
  
  /** @return �x�N�g���̐�Βl */
  def magnitude = math.sqrt(x*x+y*y)
  
  /** @return ���K�������x�N�g�� */
  def normalized = this/magnitude
  
  def +(that:Vector2) = Vector2(x+that.x, y+that.y)
  def -(that:Vector2) = Vector2(x-that.x, y-that.y)
  def *(that:Int) = Vector2(x*that, y*that)
  def *(that:Double) = Vector2(x*that, y*that)
  def /(that:Int) = Vector2(x/that, y/that)
  def /(that:Double) = Vector2(x/that, y/that)
}

object Vector2{
  /**
   * �ɍ��W����Vector2�C���X�^���X�𐶐�����.
   * @param r �x�N�g���̑傫��
   * @param theta ���W�A��
   */
  def fromTheta(r:Double, theta:Double) = {
    val ang = theta - math.Pi/2
    val x = r * math.cos(ang)
    val y = -r * math.sin(ang)
    Vector2(x,y)
  }
  
  /**
   * �ɍ��W����Vector2�C���X�^���X�𐶐�����
   * @param r �x�N�g���̑傫��
   * @param angle �p�x(�x)
   */
  def fromDegrees(r:Double, angle:Double) = fromTheta(r, math.toRadians(angle))
}