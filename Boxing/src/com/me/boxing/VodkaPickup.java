package com.me.boxing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VodkaPickup extends Pickup {
	
	private String pickupSource = "vodka.png";
	
	private Sound sound;
	private boolean soundPlayed = false;
	private String soundSource = "sound/fx/pickup.mp3";

	private static final int SIZE = 64;
	private static final int ROTATION_SPEED = 300;

	public VodkaPickup(float x, float y)
	{
		// create and size sprite
		sprite = new Sprite(new Texture(Gdx.files.internal(pickupSource)));
		sprite.setSize(SIZE * 75/340, SIZE);
		sprite.setOrigin(sprite.getX() + sprite.getWidth()/2, sprite.getY() + sprite.getHeight()/2);

		// place sprite
		sprite.setPosition(x + sprite.getWidth()/2, y);
		
		// load sound
		sound = Gdx.audio.newSound(Gdx.files.internal(soundSource));
	}

	private void update(float dt) { sprite.rotate(ROTATION_SPEED * dt); }

	public void draw(SpriteBatch batch)
	{
		if(!collected)
		{
			update(Gdx.graphics.getDeltaTime());
			sprite.draw(batch);
		}
		else if(!soundPlayed) 
		{
			sound.play();
			soundPlayed = true;
		}
	}
}