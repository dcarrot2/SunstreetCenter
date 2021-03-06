package com.csitandroiddevelopers.sunstreetcenters;

import java.util.LinkedList;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.csitandroiddevelopers.sunstreetcenters.R;
/**
 * 
 * Main activity where the game is played.
 * 
 * @author David Vavra
 * 
 */
public class GameMainActivity extends SherlockActivity {

	private GameBoardView gameBoard;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_main_activity);
		gameBoard = (GameBoardView) findViewById(R.id.gameboard);
		// use preserved tile locations when orientation changed
		@SuppressWarnings({ "deprecation", "unchecked" })
		final LinkedList<Integer> tileOrder = (LinkedList<Integer>) getLastNonConfigurationInstance();
		if (tileOrder != null) {
			gameBoard.setTileOrder(tileOrder);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.game_main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.new_game) {
			gameBoard.setTileOrder(null);
			gameBoard.fillTiles();
			return true;
		}
		else
			return super.onOptionsItemSelected(item);	
	}
	@Override
	public Object onRetainNonConfigurationInstance() {
		// preserve state when rotated
		return gameBoard.getTileOrder();
	}
}

